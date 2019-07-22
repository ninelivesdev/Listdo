package com.ninelivesdev.listdo.Controllers;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Handles reading in from the data file and writing out to it
 */
public class FileController
{
    private static final String FILENAME = "tasks.txt";

    public static ArrayList<String> readData(Context ctx)
    {
       ArrayList<String> list = null;

       try
       {
           FileInputStream fis = ctx.openFileInput(FILENAME);
           ObjectInputStream ois = new ObjectInputStream(fis);
           list = (ArrayList<String>) ois.readObject();
       }
       catch (FileNotFoundException e)
       { list = new ArrayList<>(); }
       catch (IOException e)
       { e.printStackTrace(); }
       catch (ClassNotFoundException e)
       { e.printStackTrace(); }

       return list;
    }

    public static void writeData(ArrayList<String> tasks, Context ctx)
    {
        try
        {
            FileOutputStream fos = ctx.openFileOutput(FILENAME, ctx.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tasks);
            oos.close();
        }
        catch (FileNotFoundException e)
        { e.printStackTrace(); }
        catch (IOException e)
        { e.printStackTrace(); }
    }
}
