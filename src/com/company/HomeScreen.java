package com.company;

import java.util.Scanner;

public class HomeScreen {

    Scanner myObj;

    HomeScreen(){
        myObj = new Scanner(System.in);
    }

    public String showoptions(){
        System.out.println("## Welcome to the Home Library System ##");
        System.out.println("Please select one of the following options:");
        System.out.println("1. Add a new book \n"
                + "2. Delete a book \n" + "3. Search for a book\n" + "4. Display all books\n" + "5. Exit\n");
        String option = myObj.nextLine();

        return option;
    }
}

