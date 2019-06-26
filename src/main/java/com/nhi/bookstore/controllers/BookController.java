package com.nhi.bookstore.controllers;

import com.nhi.bookstore.model.Book;
import com.nhi.bookstore.exceptions.NotFoundException;
import com.nhi.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/sample/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}/id")
    Optional<Book> get(@PathVariable int id) {
        Optional<Book> optionalBook=bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return bookRepository.findById(id);
        }
        throw new NotFoundException(String.format("Book id %d isn't exist",id));
    }

    @GetMapping()
    Iterable<Book> get() {
        return bookRepository.findAll();
    }

    @GetMapping("/find")
    Iterable<Book> find(@RequestParam String name){
        System.out.println("day ne");
        return bookRepository.findByNameContaining(name);
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        if(!bookRepository.existsById(id)){
            throw new NotFoundException(String.format("Book id %d not found", id));
        }
        bookRepository.deleteById(id);
    }

    @PostMapping()
    public void post(@RequestBody Book book) {
        book.setId(0);
        bookRepository.save(book);
    }
    @PutMapping()
    void put(@RequestBody Book book) {
        bookRepository.save(book);
    }

}
