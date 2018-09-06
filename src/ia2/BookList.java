/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tomasz
 */
@XmlRootElement(name = "books")
public class BookList {


    private List<Book> books;
    
    public BookList() {
        this.books = new ArrayList<>();
    }
    
    public BookList (List<Book> copy) {
        this.books = new ArrayList<>(copy);
    }

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
