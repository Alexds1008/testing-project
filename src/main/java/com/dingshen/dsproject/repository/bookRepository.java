package com.dingshen.dsproject.repository;

import com.dingshen.dsproject.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface bookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
