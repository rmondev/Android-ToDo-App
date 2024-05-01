package com.rmondev.android_todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedToDoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_to_do_item);

        Intent intent = getIntent();
        ToDoItem toDoItem = (ToDoItem) intent.getSerializableExtra("toDoItem");

        TextView tvTitle = findViewById(R.id.tvTitle2);
        TextView tvDetails = findViewById(R.id.tvDetails2);
        TextView tvCompletionStatus = findViewById(R.id.tvStatus2);
        TextView tvDateCreated = findViewById(R.id.tvDateCreated2);
        Button btnDeleteToDoItem = findViewById(R.id.btnDeleteToDo);
        Button btnToggleCompletion = findViewById(R.id.btnToggleCompletion);

        if (toDoItem != null) {
            tvTitle.setText(toDoItem.getTitle());
            tvDetails.setText(toDoItem.getDetails());
            tvCompletionStatus.setText(toDoItem.getCompletionStatus() ? "Completed" : "Not Completed");
            tvDateCreated.setText(toDoItem.getDueDate());
        } else {
            // Handle the case where To Do Item is null
            Toast.makeText(this, "Error: To Do Item details not found", Toast.LENGTH_SHORT).show();
            Intent intent4Err = new Intent(DetailedToDoActivity.this, MainActivity.class);
            startActivity(intent4Err);
            finish();
        }

        btnDeleteToDoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseManager databaseManager = DatabaseManager.getInstance(getApplicationContext());

                if (toDoItem != null) {
                    databaseManager.deleteItemById(toDoItem.getItemId());
                    // Provide feedback to the user
                    Toast.makeText(DetailedToDoActivity.this, "To Do Item Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailedToDoActivity.this, "Could not delete To Do item", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });

        btnToggleCompletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (toDoItem != null) {
                    Boolean prevStatus = toDoItem.getCompletionStatus();

                    DatabaseManager databaseManager = DatabaseManager.getInstance(getApplicationContext());
                    databaseManager.updateCompletionStatus(toDoItem.getItemId(), !prevStatus);
                    tvCompletionStatus.setText((!prevStatus ? "Completed" : "Not Completed"));
                    Toast.makeText(DetailedToDoActivity.this, toDoItem.getTitle() + " status set to " + (!prevStatus ? "Completed" : "Not Completed"), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DetailedToDoActivity.this, "Could not change status", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}