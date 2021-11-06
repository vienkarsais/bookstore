package lv.edgars.repository;

import lv.edgars.models.Book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

Feature/EddysVersion
public class CSVRepository implements IBookRepository {


    public static List<Book> bookShelf = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public CSVRepository() {

        try (Scanner scanner = new Scanner(new File("books.csv"))) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                bookShelf.add(createBook(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e + " vai tas ir shis?");
        }

    }

    private static Book createBook(String line) {
        String[] data = line.split(",");
        return new Book(data[0], data[1], LocalDate.of(Integer.parseInt(data[2]), 1, 1), Integer.parseInt(data[3]), data[4], data[5], data[6]);
    }

    public Book addBook(Book newbook) {
        for (Book book : bookShelf) {
            if (book.getIsbn().equals(newbook.getIsbn())) {
                System.out.println("Book already exists in the database.");

            }
        }
        bookShelf.add(newbook);
        return newbook;
    }


    public void removeBook(String isbn) {
        bookShelf.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> getAllBooks() {
        return bookShelf;
    }


Feature/EddysVersion
    public List<Book> findByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book b : bookShelf) {
            if (b.getTitle().toLowerCase().contains(title)) {
                System.out.println(b);
                foundBooks.add(b);
            }
        }
        return foundBooks;
    }

    @Override
    public void postDestroy() {
        try {
            saveIntoFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveIntoFile() throws IOException {
        File file = new File("books.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("String title, String author, LocalDate publishingYear, int pages, String publisher, String description, String isbn");
        bw.newLine();
        for (int i = 0; i < bookShelf.size(); i++) {
            // bw.write(String.valueOf(.get(i)));
            bw.write(String.valueOf(bookShelf.get(i)));
            bw.newLine();
        }
        bw.close();
        fw.close();
    }

}
