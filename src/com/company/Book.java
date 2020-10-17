package com.company;

import java.io.Serializable;

public class Book implements Serializable {
    private String title, author, year, pages;
    private String ISBN;

    public String getTitle() {
        return title;
    }

    public String getPages() {
        return pages;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPages(String pages) {
        this.pages = pages;
    }



    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ",  ISBN=" + ISBN + ", year="+ year + ",pages="+ pages +"]";
    }
}
