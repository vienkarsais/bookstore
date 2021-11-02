package lv.edgars.bookstore;

public class Display {

    public void displayBookMenu(){
        System.out.println("--------------------------");
        System.out.println("Book Store Menu:");
        System.out.println("1. Search Book by title");
        System.out.println("2. Add Book");
        System.out.println("3. Remove Book by isbn");
        System.out.println("4. Available books");
        System.out.println("To quit press: Q");
        System.out.println("--------------------------");
    }
    public void displayDataLocationMenu(){
        System.out.println("--------------------------");
        System.out.println("Choose your book store storage:");
        System.out.println("1. Use Database");
        System.out.println("2. Use CSV file");
        System.out.println("--------------------------");
    }
}
