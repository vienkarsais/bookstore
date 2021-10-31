package lv.edgars.repository;

import lv.edgars.models.Book;
import lv.edgars.repository.IBookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class BookRepository implements IBookRepository {
    private EntityManager entityManager = null;


    public BookRepository() {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            Session sessionInit = sessionFactory.openSession();
            Session session = sessionInit.getSession();
            this.entityManager = session;
        }
    }


    public Book addBook(Book book) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()){
                transaction.begin();
            }
            entityManager.persist(book);
            transaction.commit();
            return book;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }


    public void removeBook(Book book) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()){
                transaction.begin();
            }
            entityManager.remove(book);
            transaction.commit();
            return ;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    public List<Book> showAllBooks() {
        return entityManager.createQuery("from book", Book.class).getResultList();
    }

    public List<Book> findByTitle(String title) {
        return entityManager.createQuery("select b from book where b.title = :title", Book.class)
                .setParameter("title", title)
                .getResultList();
    }
}
