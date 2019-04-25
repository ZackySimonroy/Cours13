package com.example.simonroy.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.MyViewHolder> {
    List<Todo> todoList;

    public TodoRecyclerAdapter(List<Todo> todoList){
        this.todoList = todoList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titre;
        TextView description;
        TextView date;
        public MyViewHolder(View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.textView_title);
            description = itemView.findViewById(R.id.textView_description);
            date = itemView.findViewById(R.id.textView_date);
        }
    }
    @NonNull
    @Override
    public TodoRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecyclerAdapter.MyViewHolder holder, int position) {
        Todo todoToDisplay = todoList.get(position);
        holder.titre.setText(todoToDisplay.getTitle());
        holder.description.setText(todoToDisplay.getDescription());
        holder.date.setText(DateFormat.getDateInstance().format(todoToDisplay.getDateAdded()));
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
