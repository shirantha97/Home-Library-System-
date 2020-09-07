package com.company;

import java.util.ArrayList;

public class Library {

    private Book book;
    private BookList bookList;
    private ISBNFormatError isbnFormatError;

    ArrayList<Book> addedBooks = new ArrayList<Book>();


    Library(){
        book = new Book();
        bookList = new BookList();
        isbnFormatError = new ISBNFormatError();
    }

    public void addBooks(String author, String title, String year, String isbn){
        book.setAuthor(author);
        book.setISBN(isbn);
        book.setTitle(title);
        book.setYear(year);
        boolean checker = isbnFormatError.chekcISBN(isbn);
        boolean duplicate = isbnFormatError.checkDuplicates(isbn, addedBooks);
        addedBooks.add(book);
        bookList.serializelist(addedBooks);
    }

    public void exitfromLibrary(){
        bookList.serializelist(addedBooks);
    }

    public void loadlibrary(){
        addedBooks = bookList.deserializelist();
        System.out.println("\nPreviously added books to tbe library");
        for (Book b : addedBooks) {
            System.out.println(b);
        }
    }

}
