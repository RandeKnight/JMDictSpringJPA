package name.davie.andrew;
/*
 * Import the kanji character data.  
 * 
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

import org.springframework.test.context.ContextConfiguration;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ImportCharacter {
	private static final String PERSISTENCE_UNIT_NAME = "JMDictJPA";
	private static EntityManagerFactory factory;
	  
	
	public static void main(String[] args) {
		
		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    final EntityManager em = factory.createEntityManager();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {

				Character kchar = null;
				String cp_type = null;
				String rad_type=null;
				Dic_Number dicnum=null;
				String thisNode = null;
				Object currObject = null;
				List<String> thisValue = null;
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					switch (qName) {
					case "character":
						kchar = new Character();
						currObject = kchar;
						break;
					case "cp_value":
						cp_type=attributes.getValue("cp_type");
						break;
					case "rad_value":
						rad_type=attributes.getValue("rad_type");
						break;
					case "dic_ref":
						dicnum = new Dic_Number();
						dicnum.setM_vol(attributes.getValue("m_vol"));
						dicnum.setM_page(attributes.getValue("m_page"));
						dicnum.setDr_type(attributes.getValue("m_vol"));
					default:
						thisNode=qName;	
						thisValue = new ArrayList<String>();
					}

				}



				public void characters(char ch[], int start, int length)
						throws SAXException {
					String thisString = new String(ch, start, length);

					//System.out.println("nodeName="+thisNode+" value1="+thisString);
				
					switch (thisNode) {
					case "literal":
						System.out.println("entseq="+thisString);
						kchar.setLiteral(thisString);
						break;
					case "cp_value":
						if (cp_type.equals("jis208")) {
							kchar.setCpTypeJis208(thisString);
						} else {
							kchar.setCpTypeUcs(thisString);
						}
						break;
					case "rad_value":
						switch (rad_type) {
						case "classical":
							kchar.setRadicalClassical(Integer.parseInt(thisString));
							break;
						case "nelson_c":
							kchar.setRadicalNelson(Integer.parseInt(thisString));
							break;
							default:
								System.out.println("Radical type "+rad_type+" not found");
						}
						break;
					case "dic_ref":
						dicnum.setValue(thisString);
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
					case "character":
						em.getTransaction().begin();
						em.merge(kchar);
						em.getTransaction().commit();
						kchar=null;
						break;
					case "dic_ref":
						dicnum.setKchar(kchar);
						break;
					default:
						Utils.setField(currObject, thisNode, thisValue.toString());
					}
				}
			};

			saxParser.parse("src/main/resources/kanjidic2", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
