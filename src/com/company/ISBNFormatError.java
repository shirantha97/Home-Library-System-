package com.company;

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
}
