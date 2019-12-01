package ru.jurfed.jdbc.Domain;

public class Genres {

    private int genreId;

    private String genreName;

    private int bookId;

    public Genres(int genreId, String genreName, int bookId) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.bookId = bookId;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
