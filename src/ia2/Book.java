/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Tomasz
 */
@XmlType(name = "book")
public class Book {

    private String id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private Integer year;
    private Integer pages;

    public Book() {
    }

    public Book(Book bOld) {
        this.id = bOld.getId();
        this.title = bOld.getTitle();
        this.author = bOld.getAuthor();
        this.isbn = bOld.getIsbn();
        this.publisher = bOld.getPublisher();
        this.year = bOld.getYear();
        this.pages = bOld.getPages();
    }

    public Book(String id, String title, String author, String isbn, Integer year, String publisher, Integer pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author
                + ", isbn=" + isbn + ", publisher=" + publisher + ", year=" + year
                + ", pages=" + pages + '}';
    }

}
