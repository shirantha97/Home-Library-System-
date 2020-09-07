package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchBooks {

    Scanner myObj = new Scanner(System.in);

    public ArrayList<Book> searchItems(Library lib){
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
            do {
                System.out.println("Enter the Year of Publication");
                searchQuery = myObj.nextLine();
            } while (searchQuery.length() < 4);
        }
        else if (searchOption.equalsIgnoreCase("4")){
            String regex = "[0-9]+";
            do {
                System.out.println("Enter the ISBN");
                searchQuery = myObj.nextLine();
            }while (searchQuery.length() <10 || !searchQuery.matches(regex));
        }

        ArrayList<Book> searchList = lib.searchBooks(searchQuery, searchOption);
        return searchList;
    }
}

