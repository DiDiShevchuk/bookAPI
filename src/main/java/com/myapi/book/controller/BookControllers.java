package com.myapi.book.controller;

import com.myapi.book.models.Book;
import com.myapi.book.repository.BookRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookControllers {
    @Autowired
    private BookRepos bookRepos;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepos.findAll();
    }

    @PostMapping("/save")
    public String saveBook(@RequestBody Book book) {
        bookRepos.save(book);
        return "saved book";
    }

    @PutMapping(value = "update/{id}")
    public String updateBook(@PathVariable long id, @RequestBody Book book) {
        Book updateBook = bookRepos.findById(id).get();
        updateBook.setName(book.getName());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setNumberOfPages(book.getNumberOfPages());
        bookRepos.save(updateBook);
        return "update book";

    }
    @DeleteMapping(value = "/book/{id}")
    public String deleteBook(@PathVariable long id){

        Book deleteBook = bookRepos.findById(id).get();
        bookRepos.delete(deleteBook);
        return "delete book" + id;

    }

}
