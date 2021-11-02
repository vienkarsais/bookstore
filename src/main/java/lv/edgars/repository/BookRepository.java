package lv.edgars.repository;


import lv.edgars.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


public class BookRepository implements IBookRepository {
    private EntityManager entityManager;


    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Book addBook(Book book) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }


    public void removeBook(String isbn) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Query query = entityManager.createQuery("DELETE FROM Book b WHERE b.isbn = :isbn");
            query.setParameter("isbn", isbn);
            int rowsDeleted = query.executeUpdate();
            System.out.println("entities deleted: " + rowsDeleted);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Book> getAllBooks() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    public List<Book> findByTitle(String title) {
        return entityManager.createQuery(" from Book where title = :title", Book.class)
                .setParameter("title", title)
                .getResultList();
    }
}
