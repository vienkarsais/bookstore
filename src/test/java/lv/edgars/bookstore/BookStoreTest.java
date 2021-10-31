package lv.edgars.bookstore;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookStoreTest {
    @Test
    public void testBookWasAddedToBookshelf() {
        BookStore bookstore = new BookStore();

        assertEquals(0, bookstore.getBookShelf().size());

        Book book = new Book("Bada Speles", "Suzanna", LocalDate.of(1999, 4, 1), 320, "adc", "drama", "7890");
        bookstore.bookShelf.add(book);

        assertEquals(1, bookstore.getBookShelf().size());
    }

    @Test
    public void testBookWasRemovedToBookshelf() {
        BookStore bookstore = new BookStore();

        Book book = new Book("Bada Speles", "Suzanna", LocalDate.of(1999, 4, 1), 320, "adc", "drama", "7890");
        bookstore.bookShelf.add(book);

        assertEquals(1, bookstore.getBookShelf().size());

        bookstore.removeBook("7890");

        assertEquals(0, bookstore.getBookShelf().size());
    }
    @Test
    public void testSearchForABookByTitle(){
        BookStore bookStore = new BookStore();

        Book book1 = new Book("Bada Speles", "Suzanna", LocalDate.of(1999, 4, 1), 320, "adc", "drama", "7890");
        Book book2 = new Book("titanic", "Aldis", LocalDate.of(2000, 4, 1), 320, "adc", "drama", "1234");
        bookStore.bookShelf.add(book1);
        bookStore.bookShelf.add(book2);
        bookStore.searchBookByTitle("titanic");

        List<Book> foundBooks = bookStore.searchBookByTitle("titanic");
        assertEquals(1,foundBooks.size());
    }
}
