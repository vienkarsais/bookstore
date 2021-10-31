package lv.edgars.repository;

import lv.edgars.models.Book;

import java.util.List;

public interface IBookRepository {
    Book addBook(Book book);
    void removeBook(Book book);
    List<Book> showAllBooks();
    List<Book> findByTitle(String title);
}
