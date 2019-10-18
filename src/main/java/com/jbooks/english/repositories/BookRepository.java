package com.jbooks.english.repositories;

import java.util.List;
import java.util.Optional;

import com.jbooks.english.models.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    //select * from books;
    List<Book> findAll();

    //select * from books where id = 100; "john",300

    Optional<Book> findById(Long id);



}