package com.ninelivesdev.listdo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private SwipeMenuListView view;
    private ArrayList<String> list;
    private ArrayAdapter adapter;
    private EditText etInput;
    private SwipeMenuCreator creator;
    private int listIndex = -1;
    private final int END_OF_LIST_INDEX = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initMenu();
    }

    private void initComponents()
    {
        initList();
        initAdapter();
        initView();
        initTextField();
        setViewAdapter();
    }

    private void initList()
    { this.list = readData(); }

    private void initAdapter()
    { this.adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list); }

    private void initView()
    { this.view = findViewById(R.id.listView); }

    private void initTextField()
    { this.etInput = findViewById(R.id.etInput); }

    private void setViewAdapter()
    { this.view.setAdapter(adapter); }

    private void initMenu()
    {
        creator = new SwipeMenuCreator()
        {
            @Override
            public void create(SwipeMenu menu)
            {
                // Edit menu option
                SwipeMenuItem edit = new SwipeMenuItem(getApplicationContext());
                edit.setBackground(new ColorDrawable(Color.GREEN));
                edit.setWidth(170);
                edit.setIcon(R.drawable.ic_edit);
                menu.addMenuItem(edit);

                // Delete menu option
                SwipeMenuItem delete = new SwipeMenuItem(getApplicationContext());
                delete.setBackground(new ColorDrawable(Color.RED));
                delete.setWidth(170);
                delete.setIcon(R.drawable.ic_delete);
                menu.addMenuItem(delete);
            }
        };

        setViewMenuCreator();
        setViewMenuClickListener();
    }

    private void setViewMenuCreator()
    { this.view.setMenuCreator(creator); }

    private void setViewMenuClickListener()
    {
        this.view.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(int listIndex, SwipeMenu menu, int menuIndex)
            {
                setListIndex(listIndex);
                switch (menuIndex)
                {
                    case 0:
                        onEditItem();
                        break;
                    case 1:
                        onDeleteItem();
                        break;
                }
                refreshList();
                writeData();
                return true;
            }
        });
    }

    public void onAddItem(View view)
    {
        if (listIndex == END_OF_LIST_INDEX)
        { addToList(); }
        else
        { replaceInList(); }

        collapseKeyboard();
        clearTextField();
        resetListIndex();
        writeData();
    }

    private void onEditItem()
    {
        copySelectedTaskToTextField();
        expandKeyboard();
    }

    private void onDeleteItem()
    {
        removeFromList();
        resetListIndex();
    }

    private void addToList()
    { list = ListController.addToList(list, getUserInput()); }

    private void replaceInList()
    { list = ListController.replaceInList(list, listIndex, getUserInput()); }

    private void removeFromList()
    { ListController.removeFromList(list, listIndex); }

    private void refreshList()
    { adapter.notifyDataSetChanged(); }

    private void setListIndex(int listIndex)
    { this.listIndex = ListController.setListIndex(listIndex); }

    private void resetListIndex()
    { this.listIndex = ListController.resetListIndex(); }

    private String getUserInput()
    { return etInput.getText().toString(); }

    private void copySelectedTaskToTextField()
    { etInput = UIController.copySelectedTaskToTextField(list, listIndex, etInput); }

    private void clearTextField()
    { etInput = UIController.clearTextField(etInput); }

    private void collapseKeyboard()
    { UIController.collapseKeyboard(MainActivity.this); }

    private void expandKeyboard()
    { UIController.expandKeyboard(MainActivity.this); }

    private ArrayList<String> readData()
    { return FileController.readData(this); }

    private void writeData()
    { FileController.writeData(list, this); }
}
