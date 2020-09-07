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

    public boolean checkDuplicates(String isbn, ArrayList<Book> bookArrayList){
        boolean duplicate = false;
        for (Book b : bookArrayList) {
            if(isbn.equalsIgnoreCase(b.getISBN())){
                duplicate = true;
            }
        }
        return duplicate;
    }
}
