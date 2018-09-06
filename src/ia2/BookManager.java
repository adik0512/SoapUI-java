package ia2;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tomasz
 */
@WebService
public class BookManager {

    private List<Book> books;

    public BookManager(List<Book> books) {
        this.books = books;
    }

    @WebMethod
    public @WebResult(name = "bookAdded")
    boolean addBook(@WebParam(name = "book") Book book) throws Exception {
        if (!book.getTitle().equals("") || !book.getAuthor().equals("")) {
            this.books.add(book);
            return true;
        }
        return false;
    }

    @WebMethod
    public @WebResult(name = "book")
    List<Book> searchByTitle(@WebParam(name = "title") String title) {
        List<Book> result = new ArrayList<>();

        for (Book b : this.books) {
            if (b.getTitle().contains(title)) {
                result.add(b);
            }
        }
        return result;
    }

    @WebMethod
    public @WebResult(name = "book")
    List<Book> searchByAuthor(@WebParam(name = "author") String author) {
        List<Book> result = new ArrayList<>();

        for (Book b : this.books) {
            if (b.getAuthor().contains(author)) {
                result.add(b);
            }
        }
        return result;
    }

    @WebMethod
    public @WebResult(name = "book")
    Book searchByISBN(@WebParam(name = "isbn") String isbn) {
        Book result = new Book();
        for (Book b : this.books) {
            if (b.getIsbn().contains(isbn)) {
                result = b;
                break;
            }
        }
        return result;
    }
}
