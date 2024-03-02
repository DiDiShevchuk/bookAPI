package com.myapi.book.repository;

import com.myapi.book.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepos extends JpaRepository<Book, Long> {

}
