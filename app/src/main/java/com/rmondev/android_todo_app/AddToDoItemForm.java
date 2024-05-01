package com.rmondev.android_todo_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddToDoItemForm extends AppCompatActivity{

    private String selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_to_do_item_form);

        CalendarView calendarView = findViewById(R.id.cvDueDate);
        EditText etTitle = findViewById(R.id.etTitle);
        EditText etDetails = findViewById(R.id.etDetails);
        Button btnAddNewToDo = findViewById(R.id.btnAddNewToDo);

        Calendar calendar = Calendar.getInstance();
        selectedDate = calendar.get(Calendar.DAY_OF_MONTH) + "/" +
                (calendar.get(Calendar.MONTH) + 1) + "/" +
                calendar.get(Calendar.YEAR);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // Month value is zero-based, so you might want to add 1 to it
                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });

        btnAddNewToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = etTitle.getText().toString().trim();
                String details = etDetails.getText().toString().trim();

                // Validate inputs
                if (title.isEmpty() || details.isEmpty()) {
                    Toast.makeText(AddToDoItemForm.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                ToDoItem newToDoItem = new ToDoItem(etTitle.getText().toString(), etDetails.getText().toString(), selectedDate);

                DatabaseManager databaseManager = DatabaseManager.getInstance(getApplicationContext());
                databaseManager.addItem(newToDoItem);

                // Provide feedback to the user
                Toast.makeText(AddToDoItemForm.this, "New to-do item added successfully", Toast.LENGTH_SHORT).show();

                finish();

            }
        });

    }
}