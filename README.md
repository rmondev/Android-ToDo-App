# Android To Do List App

This application showcases the implementation of various android UI Elements and databse functionality.

## Features

This app includes the following features:

### Splash Screen

A simple yet effective splash screen that welcomes users to the app.

<p align="center">
  <img src="/screenshots/SplashScreen.png" alt="Splash Screen" style="width:25%;">
</p>

### RecylerView ToDo Item List

- **Functionality**: List all to do list items in a RecylerView, which renders each item at they come into view, achieving greater performance than using a ListView which loads all items at once. 

<p align="center">
  <img src="/screenshots/ToDoItemList.png" alt="Camera Permission Request" style="width:25%;">
</p>

### View To Do Item Details

- **Functionality**: When a user clicks on a To Do item in the list, a new activity is started that displays the To Do item information to the user.

<p align="center">
  <img src="/screenshots/ToDoItemDetails.png" alt="To Do Item Details" style="width:25%;">
</p>

- **Change To Do Item Status**: When a user clicks 'Toggle Status' button, the completion status for that item is changed to either complete or incomplete and the status is persisted to the database.

<p align="center">
  <img src="/screenshots/ToDoItemList.png" alt="To Do Item Status Change" style="width:25%;">
  <img src="/screenshots/ToDoItemStatusChange.png" alt="To Do Item Status Change" style="width:25%;">
  <img src="/screenshots/ToDoItemPostStatusChange.png" alt="To Do Item Status Change" style="width:25%;">
</p>

### Add New To Do Item

- **Functionality**: A form that uses UI elements such as EditText, Button and CalendrView to record and save the To Do item information from the user.

- **Result**: The new To Do item is persisted to the database.

<p align="center">
  <img src="/screenshots/AddNewToDoItem.png" alt="Add New To Do Item" style="width:25%;">
  <img src="/screenshots/NewToDoListItemAdded.png" alt="New To Do List Item Added" style="width:25%;">
</p>

### Delete To Do Item

- **Functionality**: When the user clicks on the 'Delete' button in the To Do item details screen, a "Toast" message is displayed to the user and then the user is redirected to the To Do list.

- **Result**: The To Do list item is deletion is persisted to the database.

<p align="center">
  <img src="/screenshots/ToDoItemPreDeletion.png" alt="To Do Item Pre Deletion" style="width:25%;">
  <img src="/screenshots/ToDoItemDeletion.png" alt="To Do Item Deletion" style="width:25%;">
  <img src="/screenshots/ToDoItemListPostDeletion.png" alt="To Do Item Post Deletion" style="width:25%;">
</p>

## App Demo Video

See the app in action with this demonstration video:



## Repository Extraction

This project, **Android-Multi-App**, was originally part of a larger repository focused on various Android development practices. It has now been given its own repository to highlight its individual features and enhance its visibility for portfolio purposes.

Original Repository: [Android Development Practices](https://github.com/rmondev/Android-Development/tree/main/Assignments/ToDoApplication_AS3)