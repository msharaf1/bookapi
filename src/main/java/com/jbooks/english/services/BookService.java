package com.jbooks.english.services;

import java.util.List;
import java.util.Optional;

import com.jbooks.english.models.Book;
import com.jbooks.english.repositories.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class BookService {
    private BookRepository bookRepo;
    //private int age;

    public BookService(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    //creating or uploading a book.
    public void createBook(Book book){
        bookRepo.save(book);
        
    }
    //reading all books from the table (Database)
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    //Get a book by ID
    public Book findABookById(Long id){
        Optional<Book> bookById = bookRepo.findById(id);
        if(bookById.isPresent()){
            return bookById.get();
        }else {
            return null;
        }
    }
    //updating
    public void updateBook(Book book){
        bookRepo.save(book);
    }
    //Delete
    public void deleteABook(Long id){
        bookRepo.deleteById(id);;
    }
}