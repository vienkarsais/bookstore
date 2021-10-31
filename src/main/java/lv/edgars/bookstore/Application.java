package lv.edgars.bookstore;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();
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
                    bookStore.bookShelf.add(book);
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

