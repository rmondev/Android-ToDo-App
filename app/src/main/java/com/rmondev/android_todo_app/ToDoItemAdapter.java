package com.rmondev.android_todo_app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class ToDoItemAdapter extends RecyclerView.Adapter<ToDoItemAdapter.ToDoItemViewHolder>{

    private List<ToDoItem> toDoItemList;
    private Context context;

    public ToDoItemAdapter(Context context, List<ToDoItem> toDoItemList) {
        this.context = context;
        this.toDoItemList = toDoItemList;
    }

    @NonNull
    @Override
    public ToDoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ToDoItemAdapter", "onCreateViewHolder: Inflating layout");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_item, parent, false);

        return new ToDoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoItemViewHolder holder, int position) {
        Log.d("ToDoItemAdapter", "onBindViewHolder: Binding data");
        ToDoItem toDoItem = toDoItemList.get(position);


        holder.tvTitle.setText(toDoItem.getTitle());
        holder.tvStatus.setText(toDoItem.getCompletionStatus() ? "Completed" : "Not Completed");
        holder.tvDueDate.setText(toDoItem.getDueDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the DetailedToDoActivity
                Intent intent = new Intent(context, DetailedToDoActivity.class);
                // Put the clicked ToDoItem object into the Intent's extra bundle
                intent.putExtra("toDoItem", toDoItem);
                // Start the DetailedToDoActivity with the Intent
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoItemList.size();
    }

    public static class ToDoItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvStatus, tvDueDate;

        public ToDoItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle2);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvDueDate = itemView.findViewById(R.id.tvDueDate);
        }
    }
}
