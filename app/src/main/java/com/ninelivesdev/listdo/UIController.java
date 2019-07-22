package com.ninelivesdev.listdo;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;

public class UIController
{
    static void collapseKeyboard(Activity activity)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    static void expandKeyboard(Activity activity)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    static EditText clearTextField(EditText textField)
    {
        textField.setText("");
        return textField;
    }

    static EditText copySelectedTaskToTextField(ArrayList<String>list, int listIndex, EditText textField)
    {
        textField.setText(list.get(listIndex));
        return textField;
    }
}
