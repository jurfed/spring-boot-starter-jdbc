package ru.jurfed.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import ru.jurfed.jdbc.Domain.Authors;
import ru.jurfed.jdbc.Domain.Genres;
import ru.jurfed.jdbc.service.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    BookService bookInterface;



    @MockBean
    GenreService genreService;

/*    @Repository
    public class AuthorTestConfig{

        @Bean
        public AuthorService authorService(){
            return new AuthorService() {
                @Override
                public Authors getAuthorsById(int id) {
                    return new Authors(1,"Petia",1);
                }
            };
        }
    }*/

    @Autowired
    AuthorService authorService;

    @Test
    public void getBookSize(){
        assertEquals(4, bookInterface.getCount());
    }

    @Test
    public void genreTest(){
        given(this.genreService.getGenreById(100)).willReturn(new Genres(1000,"test genre", 1));
        System.out.println(genreService.getGenreById(100));
    }


    @Test
    public void getAuthorById(){
        System.out.println(authorService.getAuthorsById(1));
    }

}
