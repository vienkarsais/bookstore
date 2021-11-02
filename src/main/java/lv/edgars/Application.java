package lv.edgars;

import lv.edgars.bookstore.BookStore;
import lv.edgars.bookstore.Display;
import lv.edgars.builders.SessionBuilder;
import lv.edgars.repository.BookRepository;
import lv.edgars.repository.CSVRepository;
import lv.edgars.repository.IBookRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display();
        IBookRepository bookRepository = null;//new BookRepository(sessionBuilder.build());
        String input = null;


        while (bookRepository == null) {
            display.displayDataLocationMenu();
            input = scanner.next();
            switch (input) {
                case "1":
                    SessionBuilder sessionBuilder = SessionBuilder.getInstance();
                    bookRepository = new BookRepository(sessionBuilder.build());
                    break;
                case "2":
                    bookRepository = new CSVRepository();
                    break;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
        BookStore bookStore = new BookStore(bookRepository);

        while (true) {
            display.displayBookMenu();
            input = scanner.next();
            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Thank you for using our services");
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("Searching for book by title");
                    bookStore.searchBookByTitle(scanner.next());
                    break;
                case "2":
                    System.out.println("Adding book");
                    bookStore.addBook();
                    break;
                case "3":
                    System.out.println("Removing book");
                    bookStore.removeBook(scanner.next());

                    break;
                case "4":
                    System.out.println("Available books in shelf:");
                    bookStore.getBookShelf();
                    break;
                default:
                    System.out.println("Wrong input, please try again");


            }
        }


    }
}

