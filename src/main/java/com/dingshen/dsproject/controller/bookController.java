package com.dingshen.dsproject.controller;

import com.dingshen.dsproject.exceptionHandling.BookIdMismatchException;
import com.dingshen.dsproject.exceptionHandling.BookNotFoundException;
import com.dingshen.dsproject.exceptionHandling.RestExceptionHandler;
import com.dingshen.dsproject.model.Book;
import com.dingshen.dsproject.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class bookController {
    @Autowired
    private bookRepository bookRepository;

    @GetMapping
    public Iterable findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/title/{booktitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findByID(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with ID" + id + "not found", null));
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if(book.getId() != id) {
            throw new BookIdMismatchException(() -> new BookIdMismatchException("Book"));
        }
        bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with ID" + id + "not found.",null));
        return bookRepository.save(book);
    }
}
