package com.ldmsh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldmsh2.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
