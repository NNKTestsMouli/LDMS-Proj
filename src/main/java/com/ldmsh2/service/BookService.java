package com.ldmsh2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldmsh2.exception.RecordNotFoundException;
import com.ldmsh2.model.Book;
import com.ldmsh2.repository.BookRepository;
 
@Service
public class BookService {
     
    @Autowired
    BookRepository repository;
     
    public List<Book> getAllBooks()
    {
        List<Book> bookList = repository.findAll();
         
        if(bookList.size() > 0) {
            return bookList;
        } else {
            return new ArrayList<Book>();
        }
    }
     
    public Book getBookById(Long id) throws RecordNotFoundException
    {
        Optional<Book> book = repository.findById(id);
         
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Book createOrUpdateBook(Book entity) throws RecordNotFoundException
    {
        Optional<Book> book = repository.findById(entity.getId());
         
        if(book.isPresent())
        {
            Book newEntity = book.get();
            newEntity.setName(entity.getName());
            newEntity.setAuthor(entity.getAuthor());
            newEntity.setIsbn(entity.getIsbn());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteBookById(Long id) throws RecordNotFoundException
    {
        Optional<Book> book = repository.findById(id);
         
        if(book.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}