package ru.jurfed.jdbc.service;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.jurfed.jdbc.Domain.Authors;
import ru.jurfed.jdbc.Domain.Books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookServiceImpl implements BookService {
    NamedParameterJdbcOperations namedParameterJdbcOperations;
    JdbcOperations jdbcOperations;

    public BookServiceImpl(NamedParameterJdbcOperations namedParameterJdbcOperations, JdbcOperations jdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Books> getBooks() {
        return this.namedParameterJdbcOperations.query("select * from books", new BookMapper());
    }

    @Override
    public Books getBookById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select * from books where bookId = :id", params, new BookMapper());
    }



    @Override
    public void createTable() {
        Map<String, Object> params = new HashMap<>();
        SqlParameterSource sqlParameterSource =new MapSqlParameterSource();
        SqlParameterSource namedParameters = new MapSqlParameterSource("first_name", 1);

        jdbcOperations.execute("DROP TABLE IF EXISTS Temptable");
        jdbcOperations.execute("create table Temptable (id integer primary key)");
        jdbcOperations.execute("insert into Temptable(id) values(100)");
    }

    @Override
    public int count2() {
        return this.jdbcOperations.queryForObject("select * from Temptable", Integer.class);
    }

    @Override
    public void insertBook(int id, String bookName) {

        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", bookName);
        namedParameterJdbcOperations.update("insert into Books(bookId,bookName) values(:id, :name)",params);
    }

    @Override
    public int getCount() {
        int count = namedParameterJdbcOperations.queryForObject("select count(*) from books",new HashMap<>(),Integer.class);
        return count;
    }


    private static class BookMapper implements RowMapper<Books> {

        @Override
        public Books mapRow(ResultSet resultSet, int i) throws SQLException {
            int bookId = resultSet.getInt("bookId");
            String bookName = resultSet.getString("bookName");
            return new Books(bookId, bookName);
        }
    }

}
