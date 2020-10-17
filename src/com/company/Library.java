package com.company;

import java.util.ArrayList;

public class Library {

    private Book book;
    private BookList bookList;
    private ISBNFormatError isbnFormatError;

    ArrayList<Book> addedBooks = new ArrayList<Book>();


    Library() {
        book = new Book();
        bookList = new BookList();
        isbnFormatError = new ISBNFormatError();
    }

    public void addBooks(String author, String title, String year, String isbn, String pages) {
        if(!(author.length() ==0) && !(title.length() ==0) && !((year.length()) ==0) && !(isbn.length() ==0) && !(pages.length() ==0)){
            book.setAuthor(author);
            book.setISBN(isbn);
            book.setTitle(title);
            book.setYear(year);
            book.setPages(pages);

            boolean checker = isbnFormatError.chekcISBN(isbn);
            boolean duplicate = isbnFormatError.checkDuplicates(book, addedBooks);
            boolean length = isbnFormatError.checkLength(isbn);
            boolean yearCheck = isbnFormatError.checkPublishYear(year);
            boolean yearlen = isbnFormatError.checkYearLength(year);
            boolean pageslen = isbnFormatError.checkPagesLength(pages);

            if (!checker) {
                System.out.println("\nISBN can only contain digits from 0-9");
                System.out.println("Please enter the details again");
            }
            if (duplicate) {
                System.out.println("\nA book with the ISBN already exists");
                System.out.println("Please enter the details again");
            }
            if (length) {
                System.out.println("\nISBN can only contain a maaximum of 10 digits only");
                System.out.println("Please enter the details again");
            }
            if (yearlen) {
                System.out.println("\nThe year of publication can only contain a maaximum of 4 digits only");
                System.out.println("Please enter the details again");
            }
            if (pageslen) {
                System.out.println("\nThe pages can only contain a maaximum of 4 digits only");
                System.out.println("Please enter the details again");
            }
            if (!yearCheck) {
                System.out.println("\nThe year of publication can only contain digits");
                System.out.println("Please enter the details again");
            }

            if (checker && (!length) && !duplicate && yearCheck && (!yearlen)) {
                System.out.println("\n"+ title + "\twas added to the library");
                addedBooks.add(book);
                bookList.serializelist(addedBooks);
            }
        }
        else {
           System.out.println("You can not leave fields empty");
        }

    }

    public ArrayList<Book> searchBooks(String query, String type) {
        ArrayList<Book> searchresults = new ArrayList<Book>();
        if(type.equalsIgnoreCase("1")){
            for (Book b : addedBooks) {
                if (query.equalsIgnoreCase(b.getTitle().toString())) {
                    searchresults.add(b);
                }
            }
        }else if(type.equalsIgnoreCase("2")){
            for (Book b : addedBooks) {
                if (query.equalsIgnoreCase(b.getAuthor().toString())) {
                    searchresults.add(b);
                }
            }
        }else if(type.equalsIgnoreCase("3")){
            for (Book b : addedBooks) {
                if (query.equalsIgnoreCase(b.getYear().toString())) {
                    searchresults.add(b);
                }
            }
        }else if(type.equalsIgnoreCase("4")){
            for (Book b : addedBooks) {
                if (query.equalsIgnoreCase(b.getISBN().toString())) {
                    searchresults.add(b);
                }
            }
        }

        return searchresults;
    }

    public ArrayList<Book> displayAll() {
        return addedBooks;
    }

    public void deleteBook(String title){
        if (addedBooks.removeIf(b -> title.equalsIgnoreCase(b.getTitle()))){
            bookList.serializelist(addedBooks);
            System.out.println(title +" has been removed from the library");
        }else {
            System.out.println("Please enter the correct details of the books to be deleted");
        }


    }

    public void exitfromLibrary () {
        //save the arraylist of object to file
        bookList.serializelist(addedBooks);
    }

    public void loadlibrary () {
        //deserrialize the file obtain a list of objects
        addedBooks = bookList.deserializelist();
//        System.out.println("\nPreviously added books to tbe library");
//        for (Book b : addedBooks) {
//            System.out.println(b);
//        }
    }

}
