/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Tomasz
 */
public class IA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BookManager bookManager = null;
        try {
            JAXBContext context = JAXBContext.newInstance(BookList.class);
            Unmarshaller um = context.createUnmarshaller();
            FileReader file = new FileReader("src/ia2/books.xml");
            BookList books = (BookList) um.unmarshal(file);
            file.close();

            bookManager = new BookManager(books.getBooks());
            List<Book> bs = bookManager.searchByTitle("Java");
            Book mojaKsiazka = new Book("1", "Laboratorium Java i XML", "Tomasz Podgorski", "881818181", 2015, "TqoE", 12);
            BookList newBooksList = new BookList();
            bs.add(mojaKsiazka);
            newBooksList.setBooks(bs);

            File fileOut = new File("src/ia2/Lab3.xml");

            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(newBooksList, fileOut);

            String url = "http://localhost:666/books";
            Endpoint.publish(url,bookManager);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
