package com.myapi.book.repository;

import com.myapi.book.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepos extends JpaRepository<Author, Long> {
}
