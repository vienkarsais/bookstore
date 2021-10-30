package lv.edgars.bookstore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Book {
    private String title;
    private String author;
    private LocalDate publishingYear;
    private int pages;
    private String publisher;
    private String description;
    private String isbn;

    public Book(String title, String author, LocalDate publishingYear, int pages, String publisher, String description, String isbn) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.pages = pages;
        this.publisher = publisher;
        this.description = description;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public LocalDate getPublishingYear() {
        return publishingYear;
    }

    public Book setPublishingYear(LocalDate publishingYear) {
        this.publishingYear = publishingYear;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingYear=" + publishingYear +
                ", pages=" + pages +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
