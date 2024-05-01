package com.rmondev.android_todo_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ToDoItem.class}, version = 1)
public abstract class ToDoItemDatabase extends RoomDatabase{

    public abstract ToDoItemDAO toDoItemDAO();

}
