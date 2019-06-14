package com.example.book_lib;

public class Book {
    private String name;
    private String author;
    private String summary;

    public Book(String name, String author, String summary) {
        this.name = name;
        this.author = author;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
