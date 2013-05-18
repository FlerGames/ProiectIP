/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author Ion Caliman
 */
public class Comment {
    private String id = "0";
    private String text = "numic";
    private String author = "anonim";
    private String location = "Iasi";
    private String data = "1/1/2013";
    private String type = "positiv";

    public Comment() {
    }
    
    public Comment(String id, String text, String author, String location, String data, String type) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.location = location;
        this.data = data;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Comment{" + "\n\tid=" + id + ", \n\ttext=" + text + ", \n\tauthor=" + author + ", \n\tlocation=" + location + ", \n\tdata=" + data + ", \n\ttype=" + type + "\n}";
    }
}
