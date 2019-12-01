package ru.jurfed.jdbc.service;

import ru.jurfed.jdbc.Domain.Authors;

public interface AuthorService {
    Authors getAuthorsById(int id);
}
