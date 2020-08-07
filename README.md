

#### Spring boot Jdbc (H2 and PostgreSQL)

    NamedParameterJdbcOperations namedParameterJdbcOperations;
    JdbcOperations jdbcOperations;
    
            final HashMap<String, Object> params = new HashMap<>(1);
            params.put("id", id);
            return namedParameterJdbcOperations.queryForObject("select * from books where bookId = :id", params, new BookMapper());
            
                private static class BookMapper implements RowMapper<Books> {
            
                    @Override
                    public Books mapRow(ResultSet resultSet, int i) throws SQLException {
                        int bookId = resultSet.getInt("bookId");
                        String bookName = resultSet.getString("bookName");
                        return new Books(bookId, bookName);
                    }
                }
            
            
            jdbcOperations.execute("DROP TABLE IF EXISTS Temptable");
            
            
            