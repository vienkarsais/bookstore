package lv.edgars.bookstore;

import lv.edgars.models.Book;
import lv.edgars.repository.IBookRepository;
import java.util.Scanner;

public class Validator {
    protected IBookRepository bookRepository;
    Scanner scanner = new Scanner(System.in);
    public Validator(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean isBookValid(Book book){
        if (bookRepository.duplicateExists(book.getIsbn())){
            System.out.println("Book already exists");
            System.out.println("try again");
            return false;
        }
        return true;
    }
    public int validateInteger(int input){
        while(input < 0){
            System.out.println("invalid number");
            System.out.println("Enter new number:");
            input = scanner.nextInt();
        }
        return input;
    }
}
