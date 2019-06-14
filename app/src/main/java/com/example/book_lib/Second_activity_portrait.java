package com.example.book_lib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_activity_portrait extends AppCompatActivity implements BookAdapter.ItemClicked {
    TextView nameFrag,authorFrag,summaryFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_portrait);

            System.out.println("Portrait mode");
            Intent intent=getIntent();
            int bookIndex=intent.getIntExtra(BookAdapter.EXTRA_INDEX,0);
            nameFrag = findViewById(R.id.nameBookFragPortrait);
            authorFrag = findViewById(R.id.authorFragPortrait);
            summaryFrag = findViewById(R.id.summaryFragPortrait);
            onItemClicked(bookIndex);

    }

    @Override
    public void onItemClicked(int index) {
        nameFrag.setText(ApplicationClass.bookArrayList.get(index).getName());
        authorFrag.setText(ApplicationClass.bookArrayList.get(index).getAuthor());
        summaryFrag.setText(ApplicationClass.bookArrayList.get(index).getSummary());
    }
}
