package com.example.book_lib;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private ArrayList<Book> books;
    ItemClicked activity;
    public interface ItemClicked{
        void onItemClicked(int index);
    }


    public BookAdapter(Context context, ArrayList<Book> list){

        this.books=list;
        activity=(ItemClicked) context;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView bookName;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            bookName=itemView.findViewById(R.id.bookName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(books.indexOf((Book) itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowlayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(books.get(i));
        viewHolder.bookName.setText(books.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
