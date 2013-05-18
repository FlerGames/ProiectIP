/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proiectip;

import java.io.FileInputStream;
import java.util.HashMap;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Ion Caliman
 */
public class ParserXML { //Streaming API for XML "StaX"
    public static HashMap<String, String> parse(String file) {
        HashMap<String, String> cmds = new HashMap<>();
        String abbr, _class;
        
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(file));
            
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                
                if (event.toString().contains("class=")) {
                    StartElement se = event.asStartElement();
                    abbr = se.getAttributeByName(new QName("abbr")).getValue();
                    _class = se.getAttributeByName(new QName("class")).getValue();
                    
                    cmds.put(abbr, _class);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return cmds;
    }
}
