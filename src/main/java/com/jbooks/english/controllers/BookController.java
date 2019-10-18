package com.jbooks.english.controllers;

import java.util.Date;
import java.util.List;

import com.jbooks.english.models.Book;
import com.jbooks.english.services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@controller
@RestController
@RequestMapping("/api")
public class BookController {
  private BookService bookServ;

  public BookController(BookService bookServ){
      this.bookServ = bookServ;
  }

    // @GetMapping("/books")
    // public String getAllBooks(){
    //     return "Your get request was succesfull";
    // }

    @GetMapping("/books")
    public List<Book> showAllBooks(){
        return bookServ.getAllBooks();
    }
    
    //@RequestMapping(value="/books/new", method=RequestMethod.GET .POST .PUT)
    //localhost/8080/api/books/new
    @PostMapping("/books/new")
    public void createBook(@RequestParam("title") String title, @RequestParam(value="authorName") String authorName, 
                            @RequestParam("price") double price, @RequestParam("published") Date published){
            Book book = new Book(title, authorName, price, published);
            bookServ.createBook(book);

    }
    //PathVariable
    @GetMapping("/books/{id}")
    public Book showABookById(@PathVariable("id") Long id, Book book){
        Book bookById = bookServ.findABookById(id);
        return bookById;
    }
    //select * books where id = 1; title, authorName, price, date;
    //Update method (PUT)
    @PutMapping("/books/update/{id}") //books/{id}/update
    public void updateABook(@PathVariable("id") Long id, Book book){
        Book bookById = bookServ.findABookById(id);
        if(bookById!=null){
            bookServ.updateBook(book);
        }
    }

    //Delete
    @DeleteMapping("/books/delete/{id}")
    public void deleteBookById(@PathVariable("id") Long id){
        bookServ.deleteABook(id);
    }
    
}