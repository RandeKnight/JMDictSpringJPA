package name.davie.andrew;
/*
 * Import the J-E dictionary data.  
 * Also populates the entry-character join table.
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ImportEntry {
	private static final String PERSISTENCE_UNIT_NAME = "JMDictJPA";
	private static EntityManagerFactory factory;
	  
	
	public static void main(String[] args) {
		
		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    final EntityManager em = factory.createEntityManager();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			System.setProperty("entityExpansionLimit", "1000000");  //Doesn't work??  Had to put it in the run settings instead.
			
			DefaultHandler handler = new DefaultHandler() {

				Entry entry = null;
				Sense sense = null;
				Lsource lsource = null;
				Audit audit = null;
				String thisNode = null;
				Object currObject = null;
				List<String> thisValue = null;
				int senseNum = 0;
				int lsourceNum = 0;  
				int auditNum = 0;
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					switch (qName) {
					case "entry":
						senseNum = 0;  //reset counter at every entry.
						lsourceNum=0;
						auditNum = 0;
						entry = new Entry();
						currObject = entry;
						break;
					case "re_nokanji":
						entry.setReNokanji("y");
						break;
					case "sense":
						sense = new Sense();
						sense.setId(senseNum);
						sense.setEnt_seq(entry.getEntSeq());
						entry.addSense(sense);
						sense.setEntry(entry);  //back reference
						currObject = sense;
						senseNum++;
						break;
/*					case "lsource":
						lsource = new Lsource();
						lsource.setId(lsourceNum);
						lsource.setEnt_seq(entry.getEntSeq());
						lsource.setLang(attributes.getValue("xml:lang"));
						lsource.setLsType(attributes.getValue("ls_type"));
						lsource.setLsWasei(attributes.getValue("ls_wasei"));
						lsource.setSense(sense);
						sense.addLsource(lsource);
						lsourceNum++;
						break;
*/
					case "audit":
						audit = new Audit();
						audit.setId(auditNum);
						audit.setEnt_seq(entry.getEntSeq());
						entry.addAudit(audit);
						audit.setEntry(entry); //back reference
						currObject = audit;
						auditNum++;
						break;
					default:
						thisNode=qName;	
						thisValue = new ArrayList<String>();
					}

				}



				public void characters(char ch[], int start, int length)
						throws SAXException {
					if (entry==null) {
						//ignore anything outside of an entry.
						return;
					}
					String thisString = new String(ch, start, length);

					//System.out.println("nodeName="+thisNode+" value1="+thisString);

					switch (thisNode) {
					case "ent_seq":
						System.out.println("entseq="+thisString);
						entry.setEntSeq(thisString);
						break;
					case "keb":
						//split and record any kanji characters (4e00 to 9faf)
						for (int n=0;n<thisString.length();n++) {
							if (thisString.codePointAt(n)>=0x4e00 && thisString.codePointAt(n)<=0x9faf) {
								Unicode unicode = new Unicode(Long.toString(thisString.codePointAt(n)),entry.getEntSeq());
								unicode.setEntry(entry);
								unicode.setLiteral(java.lang.Character.toString(thisString.charAt(n)));
								entry.addUnicode(unicode);
							}
						}
						break;
					case "lsource":
						lsource.setValue(thisString);
						break;
					default:
						thisValue.add(thisString);
					}
				}
				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					switch (qName) {
					case "ent_seq":
						break; //ignore
					case "entry":
						em.getTransaction().begin();
						em.merge(entry);
						em.getTransaction().commit();
						entry=null;
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
			};

			saxParser.parse("src/main/resources/JMdict_e", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
