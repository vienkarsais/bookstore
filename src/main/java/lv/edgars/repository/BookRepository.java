package lv.edgars.repository;



import lv.edgars.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class BookRepository implements IBookRepository {
    private EntityManager entityManager;


    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
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


    public void removeBook(String isbn) {
        entityManager.createQuery("delete isbn from Book where isbn = :isbn", Book.class)
                .setParameter("isbn", isbn);

        /*EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()){
                transaction.begin();
            }
            entityManager.remove(isbn);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }*/
    }

    public List<Book> getAllBooks() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    public List<Book> findByTitle(String title) {
        return entityManager.createQuery("select title from Book where title = :title", Book.class)
                .setParameter("title", title)
                .getResultList();
    }
}
