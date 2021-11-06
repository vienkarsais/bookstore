package lv.edgars.repository;



import lv.edgars.models.Book;
import java.util.List;

public interface IBookRepository {
    Book addBook(Book book);
    void removeBook(String isbn);
    List<Book> getAllBooks();
    List<Book> findByTitle(String title);
}
