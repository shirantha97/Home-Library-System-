package com.company;

public class Library {

    private Book book;
    private BookList bookList;

    Library(){
        book = new Book();
        bookList = new BookList();
    }

    public void addBooks(String author, String title, String year, int isbn){
        book.setAuthor(author);
        book.setISBN(isbn);
        book.setTitle(title);
        book.setYear(year);
        bookList.addtoList(book);
    }

    public void exitfromLibrary(){
        bookList.serializelist();
    }

    public void loadlibrary(){
        bookList.deserializelist();
    }

}
