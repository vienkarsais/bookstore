package lv.edgars.bookstore;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();


        while(true){
            System.out.println("Book Store Menu:");
            System.out.println("1. Search Book");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Available books");
            System.out.println("To quit press: Q");
            String input = scanner.next();
            if(input.equals("Q")){
                System.out.println("Quiting application");
                break;
            }
            switch (input){
                case "1":
                    System.out.println("Searching for book");
                    break;
                case "2":
                    System.out.println("Adding book");
                    Book book1 = new Book("bada speles", "suzanna", LocalDate.of(1999,1,18),320,"abc","15644ferfef","test");
                    bookStore.addBook(book1);
                    break;
                case "3":
                    System.out.println("Removing book");
                    break;
                case "4":
                    System.out.println("Available books in shelf:");
                    bookStore.listBooks();
                    break;
                default:
                    System.out.println("Wrong input, please try again");


            }

        }

    }
}
