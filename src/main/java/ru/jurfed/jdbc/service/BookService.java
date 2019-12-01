package ru.jurfed.jdbc.service;

import ru.jurfed.jdbc.Domain.Authors;
import ru.jurfed.jdbc.Domain.Books;
import ru.jurfed.jdbc.Domain.Genres;

import java.util.List;

public interface BookService {
    List<Books> getBooks();

    Books getBookById(int id);

    void createTable();

    public int count2();

    void insertBook(int id, String bookName);

    int getCount();
}
