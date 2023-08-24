package com.one2many;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Author {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<Books> books = Collections.emptyList();

    public Author() {
    }

    public Author(int id, String name, List<Books> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
