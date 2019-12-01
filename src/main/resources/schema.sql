DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS Books;

create table Books(
bookId int primary key,
bookName varchar(255)
);

create table authors(
authorId int primary key,
authorName varchar(255),
bookId int references Books(bookId)
);

create table genres(
genreId int primary key,
genreName varchar(255),
bookId int references Books(bookId)
);
