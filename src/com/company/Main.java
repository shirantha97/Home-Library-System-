package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();
        ISBNFormatError isbnFormatError = new ISBNFormatError();

        lib.loadlibrary();

        HomeScreen home = new HomeScreen();
        String option = home.showoptions();

        Scanner myObj = new Scanner(System.in);



//        System.out.println("## Welcome to the Home Library System ##");
//        System.out.println("Please select one of the following options:");
//        System.out.println("1. Add a new book \n"
//           + "2. Delete a book \n" + "3. Search for a book\n" + "4. Display all books\n" + "5. Exit\n");
//        option = myObj.nextLine();

        if (option.equalsIgnoreCase("1")){
            System.out.println("Enter the following Details");
            System.out.println("Enter the author's name: \t");
            String author = myObj.nextLine();
            System.out.println("Enter the title of the book: \t");
            String title = myObj.nextLine();
            System.out.println("Enter the ISBN of the book: \t");
            String isbn = myObj.nextLine();
            System.out.println("Enter the published year of the book: \t");
            String year = myObj.nextLine();

            if(isbnFormatError.chekcISBN(isbn.toString())){
                lib.addBooks(author, title, year, Integer.parseInt(isbn));
            }

            String exit = home.showoptions();

            if(exit.equalsIgnoreCase("5")){
                lib.exitfromLibrary();
            }
        }

    }

}