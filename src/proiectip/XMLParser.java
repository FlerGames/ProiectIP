/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proiectip;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import models.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ion Caliman
 */
public class XMLParser {
    public static String file1 = "src/xml/modul1.xml";
    public static String file2 = "src/xml/modul2.xml";
    public static String file3 = "src/xml/modul3.xml";
    
    
    public static ArrayList<Comment> importData() {
        ArrayList<Comment> comments = new ArrayList<>();
        
        String id;
        String text;
        String author;
        String location;
        String data;
        String type;
        
        try {
            File fXmlFile1 = new File(file1);
            File fXmlFile2 = new File(file2);
            File fXmlFile3 = new File(file3);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc1 = dBuilder.parse(fXmlFile1);
            Document doc2 = dBuilder.parse(fXmlFile2);
            Document doc3 = dBuilder.parse(fXmlFile3);
            
            NodeList comments1 = doc1.getElementsByTagName("comment");
            NodeList comments2 = doc2.getElementsByTagName("comment");
            NodeList comments3 = doc3.getElementsByTagName("comment");
            
            for (int i=0; i<comments1.getLength(); i++) {
                Element comment1 = (Element)comments1.item(i);
//                Element comment2 = (Element)comments2.item(i);
//                Element comment3 = (Element)comments3.item(i);
                
                id = comment1.getAttribute("id");
                location = comment1.getAttribute("location");
                data = comment1.getAttribute("data");
                text = comment1.getTextContent();
//                author = comment2.getAttribute("author");
//                type = comment3.getAttribute("type");
                
//                Comment comment = new Comment(id, text, author, location, data, type);
                Comment comment = new Comment();
                comment.setId(id);
                comment.setText(text);
                comment.setLocation(location);
                comment.setData(data);
                
                comments.add(comment);
            }
            for (int i=0; i<comments2.getLength(); i++) {
                Element comment2 = (Element)comments2.item(i);
                
                id = comment2.getAttribute("id");
                author = comment2.getAttribute("author");
                
                for (Comment comment : comments) {
                    if (id.equals(comment.getId())) {
                        comment.setAuthor(author);
                        break;
                    }
                }
            }
            for (int i=0; i<comments3.getLength(); i++) {
                Element comment3 = (Element)comments3.item(i);
                
                id = comment3.getAttribute("id");
                type = comment3.getAttribute("type");
                
                for (Comment comment : comments) {
                    if (id.equals(comment.getId())) {
                        comment.setType(type);
                        break;
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        for (Comment comment : comments) {
            System.out.println(comment);
        }
        
        return comments;
    }
}
