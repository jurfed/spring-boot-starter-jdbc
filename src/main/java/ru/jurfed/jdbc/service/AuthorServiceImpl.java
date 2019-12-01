package ru.jurfed.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.jurfed.jdbc.Domain.Authors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class AuthorServiceImpl implements AuthorService {

    public AuthorServiceImpl() {
    }

    @Autowired
    NamedParameterJdbcOperations namedParameterJdbcOperations;

    JdbcOperations jdbcOperations;

    public AuthorServiceImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Authors getAuthorsById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select * from authors where authorId = :id", params, new AuthorMapper());
    }

    private static class AuthorMapper implements RowMapper<Authors> {

        @Override
        public Authors mapRow(ResultSet resultSet, int i) throws SQLException {
            int authorId = resultSet.getInt("authorId");
            String bookName = resultSet.getString("authorName");
            int bookId = resultSet.getInt("bookId");
            return new Authors(authorId, bookName, bookId);
        }
    }
}
