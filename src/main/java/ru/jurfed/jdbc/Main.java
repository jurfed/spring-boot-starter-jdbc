package ru.jurfed.jdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.jurfed.jdbc.service.AuthorService;
import ru.jurfed.jdbc.service.BookService;
import ru.jurfed.jdbc.service.GenreService;


import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        Console.main(args);
        ApplicationContext context = SpringApplication.run(Main.class);

        BookService books = context.getBean(BookService.class);
        AuthorService authors = context.getBean(AuthorService.class);
        GenreService service = context.getBean(GenreService.class);

        System.out.println(books.getBookById(1));
        System.out.println(authors.getAuthorsById(1));
        System.out.println(service.getGenreById(1));
        System.out.println(books.getBooks());

        books.createTable();
        System.out.println(books.count2());

        books.insertBook(5,"adventure");
        books.insertBook(6,"my story");
        System.out.println(books.getBooks());

        System.out.println("book's size=  " + books.getCount());

    }
}
