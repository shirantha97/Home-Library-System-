package com.company;

import java.util.ArrayList;

public class ISBNFormatError {

    public boolean chekcISBN(String isbn){
        boolean checker;
        String regex = "[0-9]+";
        if (isbn.matches(regex)){
            checker = true;
        }else{
            checker = false;
        }
        return checker;
    }

    public boolean checkLength(String isbn){
        boolean len = false;
        if (isbn.length() > 10){
            len = true;
        }
        return len;
    }

    public boolean checkDuplicates(Book book, ArrayList<Book> bookArrayList){
        boolean duplicate = false;
        for (Book b : bookArrayList) {
            if(book.getISBN().equalsIgnoreCase(b.getISBN())){
                if (!book.getTitle().equalsIgnoreCase(b.getTitle())){
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }

    public boolean checkPublishYear(String year){
        boolean checker;
        String regex = "[0-9]+";
        if (year.matches(regex)){
            checker = true;
        }else{
            checker = false;
        }
        return checker;
    }

    public boolean checkYearLength(String year){
        boolean len = false;
        if (year.length() > 4){
            len = true;
        }
        return len;
    }
    public boolean checkPagesLength(String pages){
        boolean len = false;
        if (pages.length() > 4){
            len = true;
        }
        return len;
    }
}
