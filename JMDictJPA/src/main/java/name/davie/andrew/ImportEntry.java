package name.davie.andrew;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.test.context.ContextConfiguration;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@ContextConfiguration
public class ImportEntry {
	@PersistenceContext
	private static EntityManager em;
	public static void main(String[] args) {
		
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {

				Entry entry = null;
				Sense sense = null;
				Audit audit = null;
				String thisNode = null;
				Object currObject = null;
				List<String> thisValue = null;
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					switch (qName) {
					case "entry":
						entry = new Entry();
						currObject = entry;
						break;
					case "sense":
						sense = new Sense();
						entry.addSense(sense);
						sense.setEntry(entry);  //back reference
						currObject = sense;
						break;
					case "audit":
						audit = new Audit();
						entry.addAudit(audit);
						audit.setEntry(entry); //back reference
						currObject = audit;
					default:
						thisNode=qName;	
						thisValue = new ArrayList<String>();
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					switch (qName) {
					case "entry":
						em.merge(entry);
						break;
					case "sense":
						currObject = entry;
						break;
					case "audit":
						currObject = entry;
						break;
					default:
						Utils.setField(currObject, thisNode, thisValue.toString());
					}
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					String thisString = new String(ch);
					switch (thisString) {
					case "ent_seq":
						entry.setEntSeq(thisString);
						break;
					case "keb":
						//split and record any kanji characters (4e00 to 9faf)
						for (int n=0;n<thisString.length();n++) {
							if (thisString.codePointAt(n)>=0x4e00 && thisString.codePointAt(n)<=0x9faf) {
								Unicode unicode = new Unicode();
								unicode.setEntry(entry);
								unicode.setLiteral(java.lang.Character.toString(thisString.charAt(n)));
								entry.addUnicode(unicode);
							}
						}
					default:
						thisValue.add(thisString);
					}
				}
			};

			saxParser.parse("main/resources/JMdict_e", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
