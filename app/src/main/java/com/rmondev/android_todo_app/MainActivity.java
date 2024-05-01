package com.rmondev.android_todo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.CDATASection;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ToDoItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddToDoItem = findViewById(R.id.btnAddToDoItem);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ToDoItemAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);


        // Populate RecyclerView with database entries
        setupToDoListDataSet();

        //Delete database
        //DatabaseUtils.deleteDatabase(getApplicationContext(), "Assignment3.db");


        btnAddToDoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddToDoItemForm.class);
                startActivity(intent);
            }
        });


    }

    private void clearDatabase() {

        DatabaseManager databaseManager = DatabaseManager.getInstance(getApplicationContext());

        databaseManager.deleteAllItems();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Populate RecyclerView with database entries
        setupToDoListDataSet();
    }

    private void setupToDoListDataSet() {
        DatabaseManager databaseManager = DatabaseManager.getInstance(getApplicationContext());
        databaseManager.getAllItemsAsync(new DatabaseManager.OnDataFetchedListener() {
            @Override
            public void onDataFetched(List<ToDoItem> items) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new ToDoItemAdapter(MainActivity.this, items);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}