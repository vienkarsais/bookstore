package lv.edgars.bookstore;

import lv.edgars.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display();

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            Session sessionInit = sessionFactory.openSession();
            Session session = sessionInit.getSession();

            BookRepository bookRepository = new BookRepository(session);
            BookStore bookStore = new BookStore(bookRepository);


        while(true){
            display.menu();
            String input = scanner.next();
            if(input.equalsIgnoreCase("Q")){
                System.out.println("Thank you for using our services");
                break;
            }
            switch (input){
                case "1":
                    System.out.println("Searching for book by title");

                    bookStore.searchBookByTitle(scanner.next());
                    break;
                case "2":
                    System.out.println("Adding book");
                    bookStore.addBook();
                    //bookStore.bookRepository.addBook(book);
                    break;
                case "3":
                    System.out.println("Removing book");
                    bookStore.removeBook(scanner.next());

                    break;
                case "4":
                    System.out.println("Available books in shelf:");
                    bookStore.getBookShelf().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Wrong input, please try again");


            }
        }

        }

    }
}

