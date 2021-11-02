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
        bookRepository.addBook(book);
        return book;
    }
    public void removeBook(String isbn){
        bookRepository.removeBook(isbn);
    }
    public void getBookShelf() {
        List<Book> bookList = bookRepository.getAllBooks();
        for (Book b : bookList){
            System.out.println(String.format("ID: %d | Title: %s | Pages: %d | Description: %s | Author: %s | Publishing year: %tF | Publisher: %s | Isbn: %s",
                    b.getId(),
                    b.getTitle(),
                    b.getPages(),
                    b.getDescription(),
                    b.getAuthor(),
                    b.getPublishingYear(),
                    b.getPublisher(),
                    b.getIsbn()));
        }
    }
    public void searchBookByTitle(String title) {
       List<Book> bookList = bookRepository.findByTitle(title);
        for (Book b : bookList){
            System.out.println(String.format("ID: %d | Title: %s | Pages: %d | Description: %s | Author: %s | Publishing year: %tF | Publisher: %s | Isbn: %s",
                    b.getId(),
                    b.getTitle(),
                    b.getPages(),
                    b.getDescription(),
                    b.getAuthor(),
                    b.getPublishingYear(),
                    b.getPublisher(),
                    b.getIsbn()));
        }
    }

}
