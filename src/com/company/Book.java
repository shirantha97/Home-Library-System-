package com.company;

import java.io.Serializable;

public class Book implements Serializable {
    private String title, author, year;
    private int ISBN;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Book [id=" + title + ", author=" + author + ",  ISBN=" + ISBN + ", year="+ year +"]";
    }
}
