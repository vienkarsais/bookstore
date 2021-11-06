package lv.edgars.bookstore;



import lv.edgars.repository.IBookRepository;


import lv.edgars.models.Book;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

public class BookStore {
    Scanner scanner = new Scanner(System.in);
    IBookRepository bookRepository;

    public BookStore(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public Book addBook(){
        Book book1 = new Book();

        System.out.println("Enter title:");
        book1.setTitle(scanner.nextLine());
        System.out.println("Enter author:");
        book1.setAuthor(scanner.nextLine());
        System.out.println("How many pages:");
        book1.setPages(scanner.nextInt());
        System.out.println("Enter publisher:");
        book1.setPublisher(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Enter description:");
        book1.setDescription(scanner.nextLine());
        System.out.println("Enter isbn code:");
        book1.setIsbn(scanner.nextLine());
        System.out.println("Enter publishing year:");
        Integer year = Integer.valueOf(scanner.nextLine());
        LocalDate publishingYear = LocalDate.of(year,1,1);
        book1.setPublishingYear(publishingYear);
        bookRepository.addBook(book1);
        return book1;
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
