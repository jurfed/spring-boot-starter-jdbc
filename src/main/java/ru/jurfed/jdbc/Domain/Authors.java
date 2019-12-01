package ru.jurfed.jdbc.Domain;

public class Authors {

    private int authorId;

    private String authorName;

    private int bookId;

    public Authors(int authorId, String authorName, int bookId) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
