package com.ninelivesdev.listdo.Controllers;

import java.util.ArrayList;

public class ListController
{
    final static int END_OF_LIST_INDEX = -1;

    public static ArrayList<String> addToList(ArrayList<String> list, String userInput)
    {
        list.add(userInput);
        return list;
    }

    public static ArrayList<String> replaceInList(ArrayList<String> list, int listIndex, String userInput)
    {
        list.set(listIndex, userInput);
        return list;
    }

    public static ArrayList<String> removeFromList(ArrayList<String> list, int listIndex)
    {
        list.remove(listIndex);
        return list;
    }

    public static int setListIndex(int listIndex)
    { return listIndex; }

    public static int resetListIndex()
    { return END_OF_LIST_INDEX; }
}
