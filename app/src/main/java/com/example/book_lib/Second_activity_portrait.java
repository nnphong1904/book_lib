package com.example.book_lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_activity_portrait extends AppCompatActivity implements BookAdapter.ItemClicked {
    TextView nameFrag,authorFrag,summaryFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_portrait);
        if(findViewById(R.id.portrait_layout)!=null) {
            nameFrag = findViewById(R.id.nameBookFrag);
            authorFrag = findViewById(R.id.authorFrag);
            summaryFrag = findViewById(R.id.summaryFrag);
            onItemClicked(0);
        }
    }

    @Override
    public void onItemClicked(int index) {
        nameFrag.setText(ApplicationClass.bookArrayList.get(index).getName());
        authorFrag.setText(ApplicationClass.bookArrayList.get(index).getAuthor());
        summaryFrag.setText(ApplicationClass.bookArrayList.get(index).getSummary());
    }
}
