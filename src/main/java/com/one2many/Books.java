package com.one2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Books {
    @Id
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    public Books() {
    }

    public Books(int id, String bookName, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName=" + bookName +
                ", author=" + author +
                '}';
    }
}
