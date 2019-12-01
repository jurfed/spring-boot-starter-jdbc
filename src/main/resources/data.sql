insert into books(bookId, bookName) values (1, 'Java');
insert into books(bookId, bookName) values (2, 'c++');
insert into books(bookId, bookName) values (3, 'c#');
insert into books(bookId, bookName) values (4, 'javaScript');

insert into authors(authorId, authorName, bookId) values (1, 'Ivanov', 1);
insert into authors(authorId, authorName, bookId) values (2, 'sidorov', 1);
insert into authors(authorId, authorName, bookId) values (3, 'Petrov', 2);
insert into authors(authorId, authorName, bookId) values (4, 'Kokoshkin', 3);
insert into authors(authorId, authorName, bookId) values (5, 'Vasiyatkov', 3);
insert into authors(authorId, authorName, bookId) values (6, 'Kulakova', 3);
insert into authors(authorId, authorName, bookId) values (7, 'Lukianin', 4);

insert into genres(genreId, genreName, bookId) values (1, 'programming', 1);
insert into genres(genreId, genreName, bookId) values (2, 'fantastic', 2);
insert into genres(genreId, genreName, bookId) values (3, 'comedy', 3);
insert into genres(genreId, genreName, bookId) values (4, 'medicine', 4);