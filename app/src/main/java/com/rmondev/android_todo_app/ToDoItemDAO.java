package com.rmondev.android_todo_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoItemDAO {
    @Query("SELECT * FROM todoitem")
    List<ToDoItem> getAllItems();

    @Query("SELECT * FROM todoitem WHERE itemId = :itemId")
    ToDoItem getItemById(int itemId);

    @Insert
    void insertAll(ToDoItem... toDoItems);

    @Delete
    void delete(ToDoItem item);

    @Update
    void update(ToDoItem item);


}

