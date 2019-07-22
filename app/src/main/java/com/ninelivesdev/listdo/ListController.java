package com.ninelivesdev.listdo;

import android.widget.Toast;

import java.util.ArrayList;

class ListController
{
    final static int END_OF_LIST_INDEX = -1;

    static ArrayList<String> addToList(ArrayList<String> list, String userInput)
    {
        list.add(userInput);
        return list;
    }

    static ArrayList<String> replaceInList(ArrayList<String> list, int listIndex, String userInput)
    {
        list.set(listIndex, userInput);
        return list;
    }

    static ArrayList<String> removeFromList(ArrayList<String> list, int listIndex)
    {
        list.remove(listIndex);
        return list;
    }

    static int setListIndex(int listIndex)
    { return listIndex; }

    static int resetListIndex()
    { return END_OF_LIST_INDEX; }
}
