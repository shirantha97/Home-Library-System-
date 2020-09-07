package com.company;

import java.io.*;
import java.util.ArrayList;

public class BookList {

//    private ArrayList<Book> listofBooks;
    ArrayList<Book> addedBooks = new ArrayList<Book>();


    BookList(){
        addedBooks  = new ArrayList<>();
    }

    public void addtoList(Book book){
        addedBooks.add(book);
    }

    public void serializelist(){
        try
        {
            FileOutputStream fos = new FileOutputStream("booklist");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(addedBooks);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void deserializelist(){

        try
        {
            FileInputStream fis = new FileInputStream("booklist");
            ObjectInputStream ois = new ObjectInputStream(fis);

            addedBooks = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("\nPreviously added books to tbe library");
        for (Book b : addedBooks) {
            System.out.println(b);
        }

    }
}
