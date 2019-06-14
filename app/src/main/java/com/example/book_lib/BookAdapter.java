package com.example.book_lib;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private ArrayList<Book> books;
    private RecyclerView mRecylerview;
    private Context myContext;
    private int landscape=2131165268;
    private int portrait=2131165269;
    ItemClicked activity;
    public interface ItemClicked{
        void onItemClicked(int index);
    }


    public BookAdapter(Context context, ArrayList<Book> list){

        this.books=list;
        this.myContext=context;
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
                    if (mRecylerview.getId()==landscape)
                    {
                        System.out.println("Landscape mode");
                        activity.onItemClicked(books.indexOf((Book) itemView.getTag()));

                    }
                    else {
                        System.out.println("Portrait mode");
                        activity.onItemClicked(books.indexOf((Book) itemView.getTag()));
                        Intent intent=new Intent(myContext,Second_activity_portrait.class);
                        myContext.startActivity(intent);

                    }


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
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecylerview = recyclerView;
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
