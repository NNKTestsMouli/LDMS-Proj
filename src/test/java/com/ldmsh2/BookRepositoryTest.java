package com.ldmsh2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ldmsh2.model.Book;
import com.ldmsh2.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void testFindAll() {

        //entityManager.persist(new Book("C++"));

        List<Book> books = repository.findAll();
        assertEquals(2, books.size());

        //assertThat(books).extracting(Book::getName).containsOnly("C++");

    }

}
