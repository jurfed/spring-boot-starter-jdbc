package ru.jurfed.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.jurfed.jdbc.Domain.Genres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class GenresImps implements GenreService {

    public GenresImps() {
        System.out.println();
    }

    @Autowired
    NamedParameterJdbcOperations namedParameterJdbcOperations;

    JdbcOperations jdbcOperations;

    public GenresImps(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Genres getGenreById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select * from genres where genreId = :id", params, new GenreMapper());
    }

    private static class GenreMapper implements RowMapper<ru.jurfed.jdbc.Domain.Genres> {

        @Override
        public ru.jurfed.jdbc.Domain.Genres mapRow(ResultSet resultSet, int i) throws SQLException {
            int genreId = resultSet.getInt("genreId");
            String bookName = resultSet.getString("genreName");
            int bookId = resultSet.getInt("bookId");
            return new ru.jurfed.jdbc.Domain.Genres(genreId, bookName, bookId);
        }
    }
}
