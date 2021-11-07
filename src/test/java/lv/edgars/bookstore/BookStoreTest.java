package lv.edgars.bookstore;


import lv.edgars.builders.SessionBuilder;
import lv.edgars.models.Book;
import lv.edgars.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookStoreTest {
    protected EntityManager entityManager;
    protected SessionBuilder sessionBuilder = SessionBuilder.getInstance();
    protected BookRepository bookRepository;
    protected static SessionFactory sessionFactory;
    protected Session session;

    @BeforeAll
    public static void classSetUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @BeforeEach
    public void setUp() {
        beginSessionTransactionAndSaveToHolder();
        bookRepository = new BookRepository(sessionBuilder.build());
    }

    @AfterEach
    public void tearDown() {
        sessionCommitAndClose();
    }

    private void beginSessionTransactionAndSaveToHolder() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    private void sessionCommitAndClose() {
        session.getTransaction().rollback();
        session.close();
    }

    @Test
    public void testIfBookIsAddedDB(){
        Book book1 = new Book("Test","test",LocalDate.of(2000,1,1),20,"test","test","123");
        int size = bookRepository.getAllBooks().size();
        bookRepository.addBook(book1);

        assertEquals(size + 1, bookRepository.getAllBooks().size());
        bookRepository.removeBook("123");
    }

    @Test
    public void testIfBookIsRemovedDB(){
        Book book1 = new Book("Test","test",LocalDate.of(2000,1,1),20,"test","test","123");
        bookRepository.addBook(book1);
        int size = bookRepository.getAllBooks().size();
        bookRepository.removeBook("123");
        assertEquals(size - 1, bookRepository.getAllBooks().size());
    }
    @Test
    public void testListSizeDB(){
        int size = bookRepository.getAllBooks().size();
        assertEquals(size, bookRepository.getAllBooks().size());
    }

    @Test
    public void testIfSearchWorksDB(){
        Book book1 = new Book("Test","test",LocalDate.of(2000,1,1),20,"test","test","123");
        bookRepository.addBook(book1);
        assertEquals(1,bookRepository.findByTitle("Test").size());
        bookRepository.removeBook("123");
    }
}
