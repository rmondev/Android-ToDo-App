package com.rmondev.android_todo_app;

import java.time.LocalDateTime;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;


@Entity
public class ToDoItem implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int itemId;
    @ColumnInfo(name = "Title")
    private String title;
    @ColumnInfo(name = "Details")
    private String details;
    @ColumnInfo(name = "Due Date")
    private String dueDate;
    @ColumnInfo(name = "Completion Status")
    private Boolean completionStatus;

    public ToDoItem(String title, String details, String dueDate) {
        this.title = title;
        this.details = details;
        this.dueDate = dueDate;
        this.completionStatus = false;
    }

    public ToDoItem(String title, String details, String dueDate, Boolean state) {
        this.title = title;
        this.details = details;
        this.dueDate = dueDate;
        this.completionStatus = state;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(Boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
}
