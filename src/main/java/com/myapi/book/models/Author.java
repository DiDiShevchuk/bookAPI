package com.myapi.book.models;

import jakarta.persistence.*;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String surname;
    @Column
    private String name;

    public Author() {

    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setId(long id){
        this. id= id;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name){
        this.name = name;
    }
}
