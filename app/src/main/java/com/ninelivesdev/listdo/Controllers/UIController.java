package com.ninelivesdev.listdo.Controllers;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.ArrayList;


public class UIController
{
    public static void collapseKeyboard(Activity activity)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static void expandKeyboard(Activity activity)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public static EditText clearTextField(EditText textField)
    {
        textField.setText("");
        return textField;
    }

    public static EditText copySelectedTaskToTextField(ArrayList<String>list, int listIndex, EditText textField)
    {
        textField.setText(list.get(listIndex));
        return textField;
    }

    public static void alertEmptyTextField(View view)
    { Snackbar.make(view, "Enter text before adding to list", Snackbar.LENGTH_LONG).show(); }
}
