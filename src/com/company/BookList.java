package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BookList {

    ArrayList<Book> loadBooks;


    BookList(){
        loadBooks  = new ArrayList<>();
    }

    public void serializelist(ArrayList<Book> addedBooks){
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

    public ArrayList<Book> deserializelist(){

        if (new File("booklist").exists()){
            try
            {
                FileInputStream fis = new FileInputStream("booklist");
                ObjectInputStream ois = new ObjectInputStream(fis);

                loadBooks = (ArrayList) ois.readObject();

                ois.close();
                fis.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c)
            {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }



        return loadBooks;

    }
}
