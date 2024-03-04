package com.myapi.book.controller;

import com.myapi.book.models.Author;
import com.myapi.book.repository.AuthorRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepos authorRepos;

    @GetMapping("/authors")
       public List<Author> getAuthor(){
        return authorRepos.findAll();
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@RequestBody Author author){
        authorRepos.save(author);
        return "saved author";
    }
    @PutMapping(value = "updateAuthor/{id}")
    public String updateAuthor(@PathVariable long id, @RequestBody Author author){
        Author updateAuthor = authorRepos.findById(id).get();
        updateAuthor.setSurname(author.getSurname());
        updateAuthor.setName(author.getName());
        authorRepos.save(updateAuthor);
        return "update author";
    }
    @DeleteMapping(value = "/author/{id}")
    public String deleteAuthor(@PathVariable long id){
        Author deleteAuthor = authorRepos.findById(id).get();
        authorRepos.delete(deleteAuthor);
        return "delete author :" + id;
    }
}
