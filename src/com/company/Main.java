package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();
        SearchBooks searchBooks = new SearchBooks();
        ISBNFormatError isbnFormatError = new ISBNFormatError();

        lib.loadlibrary();

        Scanner myObj = new Scanner(System.in);
        String option = "5";


        do {
        System.out.println("\n## Welcome to the Home Library System ##");
        System.out.println("\nPlease select one of the following options:");
        System.out.println("1. Add a new book \n"
                    + "2. Delete a book \n" + "3. Search for a book\n" + "4. Display all books\n" + "5. Exit\n");
        option = myObj.nextLine();

        if (option.equalsIgnoreCase("1")){
            System.out.println("Enter the following Details");
            System.out.print("Enter the author's name: \t");
            String author = myObj.nextLine();
            System.out.print("Enter the title of the book: \t");
            String title = myObj.nextLine();
            System.out.print("Enter the ISBN of the book: \t");
            String isbn = myObj.nextLine();
            System.out.print("Enter the published year of the book: \t");
            String year = myObj.nextLine();

            lib.addBooks(author, title, year, isbn);

        }
        else if(option.equalsIgnoreCase("3")){
            System.out.println("Search for a book by:");
            ArrayList<Book> searchList = searchBooks.searchItems(lib);
            if (!searchList.isEmpty()){
                searchList.sort(Comparator.comparing(Book::getTitle));
                for (Book book : searchList){
                    System.out.println("\nTitle : \t" + book.getTitle());
                    System.out.println("Author : \t" + book.getAuthor());
                    System.out.println("Year : \t" + book.getYear());
                    System.out.println("ISBN : \t" + book.getISBN());
                }
            }else {
                System.out.println("There is no books available under that title");
            }
        }
        else if(option.equalsIgnoreCase("2")){
            System.out.println("Search for a book for deletion by:");
            ArrayList<Book> searchList = searchBooks.searchItems(lib);
            if (!searchList.isEmpty()){
                for (Book book : searchList){
                    System.out.println("\nTitle : \t" + book.getTitle());
                    System.out.println("Author : \t" + book.getAuthor());
                    System.out.println("Year : \t" + book.getYear());
                    System.out.println("ISBN : \t" + book.getISBN());
                }
                System.out.print("Enter the title of the book to delete: \t");
                String deleteQuery = myObj.nextLine();
                lib.deleteBook(deleteQuery);
            }else {
                System.out.println("There is no books available under that title");
            }
        }
        else if(option.equalsIgnoreCase("4")){
            ArrayList<Book> allBooks = lib.displayAll();
            if (!allBooks.isEmpty()){
                Collections.sort(allBooks, Comparator.comparing(Book::getTitle));
                for(Book book:allBooks){
                    System.out.println("\nTitle : \t" + book.getTitle());
                    System.out.println("Author : \t" + book.getAuthor());
                    System.out.println("Year : \t" + book.getYear());
                    System.out.println("ISBN : \t" + book.getISBN());
                }
            }else {
                System.out.println("There are no books available at the moment");
            }

        }
        else if(option.equalsIgnoreCase("5")){
            lib.exitfromLibrary();
        }
        else {
            System.out.println("Please enter the correct option");
        }

        } while (!(option.equalsIgnoreCase("5")));

        lib.exitfromLibrary();

    }

}
