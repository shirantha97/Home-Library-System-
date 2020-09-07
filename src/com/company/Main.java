package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();

        lib.loadlibrary();

        Scanner myObj = new Scanner(System.in);

        System.out.println("## Welcome to the Home Library System ##");
        System.out.println("Please select one of the following options:");
        System.out.println("1. Add a new book \n"
                    + "2. Delete a book \n" + "3. Search for a book\n" + "4. Display all books\n" + "5. Exit\n");
        String option = myObj.nextLine();

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

            lib.addBooks(author, title, year, isbn);

        }
        else if(option.equalsIgnoreCase("3")){
            System.out.println("Please select the preferred method");
            System.out.println("1. Title \n"
                    + "2. Author \n" + "3. Year of Publication\n" + "4. ISBN number\n");
            String searchOption = myObj.nextLine();
            String searchQuery = "";
            if (searchOption.equalsIgnoreCase("1")){
                System.out.println("Enter the title");
                searchQuery = myObj.nextLine();
            }
            else if (searchOption.equalsIgnoreCase("2")){
                System.out.println("Enter the Author");
                searchQuery = myObj.nextLine();
            }
            else if (searchOption.equalsIgnoreCase("3")){
                System.out.println("Enter the Year of Publication");
                searchQuery = myObj.nextLine();
            }
            else if (searchOption.equalsIgnoreCase("4")){
                System.out.println("Enter the ISBN");
                searchQuery = myObj.nextLine();
            }

            ArrayList<Book> searchList = lib.searchBooks(searchQuery, searchOption);
            if (!searchList.isEmpty()){
                for (Book book : searchList){
                    System.out.println("\nTitle : \t" + book.getTitle());
                    System.out.println("Author : \t" + book.getAuthor());
                    System.out.println("Published Year : \t" + book.getYear());
                    System.out.println("ISBN : \t" + book.getISBN());
                }
            }else {
                System.out.println("There is no books available under that title");
            }


        }
        else if(option.equalsIgnoreCase("2")){

        }
        else if(option.equalsIgnoreCase("4")){

        }
        else if(option.equalsIgnoreCase("5")){
            lib.exitfromLibrary();
        }
    }

}
