package com.rmondev.android_todo_app;

import androidx.room.Room;
import android.content.Context;
import java.util.List;
public class DatabaseManager {
    private static DatabaseManager instance;
    private final Context context;
    private final ToDoItemDAO toDoItemDAO;

    private DatabaseManager(Context context) {
        this.context = context;
        // Initialize Room database
        ToDoItemDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                ToDoItemDatabase.class, "dbRoom_ToDoItemDatabase").build();
        toDoItemDAO = db.toDoItemDAO();
    }

    // Singleton getInstance method to get the single instance of DatabaseManager
    public static synchronized DatabaseManager getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
        return instance;
    }

    // Method to add a new item to the database
    public void addItem(ToDoItem item) {
        new Thread(() -> toDoItemDAO.insertAll(item)).start();
    }

    // Method to delete all items from the database
    public void deleteAllItems() {
        new Thread(() -> {
            List<ToDoItem> itemList = toDoItemDAO.getAllItems();
            for (ToDoItem item : itemList) {
                toDoItemDAO.delete(item);
            }
        }).start();
    }

    // Method to delete a ToDoItem by itemId
    public void deleteItemById(int itemId) {
        new Thread(() -> {
            ToDoItem item = toDoItemDAO.getItemById(itemId);
            if (item != null) {
                toDoItemDAO.delete(item);
            }
        }).start();
    }

    // Method to update completionStatus of a ToDoItem by itemId
    public void updateCompletionStatus(int itemId, boolean completionStatus) {
        new Thread(() -> {
            ToDoItem item = toDoItemDAO.getItemById(itemId);
            if (item != null) {
                item.setCompletionStatus(completionStatus);
                toDoItemDAO.update(item); // Update the item in the database using the update method
            }
        }).start();
    }


    public void getAllItemsAsync(OnDataFetchedListener listener) {
        new Thread(() -> {
            List<ToDoItem> items = toDoItemDAO.getAllItems();
            listener.onDataFetched(items);
        }).start();
    }

    public interface OnDataFetchedListener {
        void onDataFetched(List<ToDoItem> items);
    }

}
