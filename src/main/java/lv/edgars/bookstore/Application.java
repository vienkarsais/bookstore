package lv.edgars.bookstore;


import lv.edgars.models.Book;
import lv.edgars.repository.BookRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore(new BookRepository());
        Display display = new Display();

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
                    Book book = bookStore.addBook();
                    bookStore.bookRepository.addBook(book);
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

