package lv.edgars.bookstore;

import lv.edgars.models.Book;
import lv.edgars.repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore {
    protected List<Book> bookShelf = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    BookRepository bookRepository;
    public BookStore(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public Book addBook(){
        Book book = new Book();

        System.out.println("Enter title:");
        book.setTitle(scanner.nextLine());
        System.out.println("Enter author:");
        book.setAuthor(scanner.nextLine());
        System.out.println("How many pages:");
        book.setPages(scanner.nextInt());
        System.out.println("Enter publisher:");
        book.setPublisher(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Enter description:");
        book.setDescription(scanner.nextLine());
        System.out.println("Enter isbn code:");
        book.setIsbn(scanner.nextLine());
        System.out.println("Enter publishing year:");
        Integer year = Integer.valueOf(scanner.nextLine());
        LocalDate publishingYear = LocalDate.of(year,1,1);
        book.setPublishingYear(publishingYear);
        //bookRepository.addBook(book);
        return book;
    }
    public void removeBook(String isdn){
        bookShelf.removeIf(book -> book.getIsbn().equals(isdn));
    }
    public List<Book> getBookShelf() {
        return bookShelf;
    }
    public List<Book> searchBookByTitle(String query) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookShelf){
            if (book.getTitle().contains(query)){
                System.out.println(book);
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

}
