package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SearchBooks {

    Scanner myObj = new Scanner(System.in);

    public ArrayList<Book> searchItems(Library lib){
        System.out.println("1. Title \n"
                + "2. Author \n" + "3. Year of Publication\n" + "4. ISBN number\n");
        String searchOption = myObj.nextLine();
        String searchQuery = "";
        if (searchOption.equalsIgnoreCase("1")){
            System.out.print("Enter the title: \t");
            searchQuery = myObj.nextLine();
        }
        else if (searchOption.equalsIgnoreCase("2")){
            System.out.print("Enter the Author: \t");
            searchQuery = myObj.nextLine();
        }
        else if (searchOption.equalsIgnoreCase("3")){
            String regex = "[0-9]+";
            do {
                System.out.print("Enter the Year of Publication \t");
                searchQuery = myObj.nextLine();
            } while (searchQuery.length() < 4 && !searchQuery.matches(regex) );
        }
        else if (searchOption.equalsIgnoreCase("4")){
            String regex = "[0-9]+";
            do {
                System.out.print("Enter the ISBN: \t");
                searchQuery = myObj.nextLine();
            }while (searchQuery.length() <10 && !searchQuery.matches(regex));
        }

        return lib.searchBooks(searchQuery, searchOption);
    }
}

