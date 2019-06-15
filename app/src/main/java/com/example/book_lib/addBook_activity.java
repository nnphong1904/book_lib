package com.example.book_lib;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addBook_activity extends AppCompatActivity {
//    Intent intent=getIntent();
//    int screenModeNo=intent.getIntExtra(MainActivity.EXTRA_SCREENMODE,0);
    EditText bookname,author,summary;
    Button addbook;
    BookListFrag bookListFrag=null;
    BookListFrag_Portrait bookListFrag_portrait=null;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_activity);
        bookname=findViewById(R.id.edBookName);
        author=findViewById(R.id.edAuthorName);
        summary=findViewById(R.id.edSummary);

        addbook=findViewById(R.id.addBook);

        fragmentManager=this.getSupportFragmentManager();

            if (MainActivity.bookListFrag!=null){
                bookListFrag= MainActivity.bookListFrag;
                System.out.println("LAYOUT ID LANDSCAPE: "+ bookListFrag.getId());
            }
            else {
                bookListFrag_portrait=MainActivity.bookListFrag_portrait;
                System.out.println("LAYOUT ID PORTRAIT: "+ bookListFrag_portrait.getId());
            }

//            bookListFrag_portrait=MainActivity.bookListFrag_portrait;
//
            addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookname.getText().toString().isEmpty()||author.getText().toString().isEmpty()||summary.getText().toString().isEmpty())
                {
                    Toast.makeText(addBook_activity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    Book newBook= new Book(bookname.getText().toString().trim(),author.getText().toString().trim(),summary.getText().toString().trim());
                    ApplicationClass.bookArrayList.add(newBook);
                    System.out.println("New Book is: "+ newBook.getName()+" "+newBook.getAuthor()+" "+newBook.getSummary()+" "+"New Size: " +ApplicationClass.bookArrayList.size());
                    Toast.makeText(addBook_activity.this,"A new book is added",Toast.LENGTH_SHORT).show();
                    bookname.setText(null);
                    author.setText(null);
                    summary.setText(null);
                    if (bookListFrag!=null) {
                        bookListFrag.notifyDataChanged();
                        System.out.println("DATA IN LANDSCAPE MODE CHANGED");
                        backToMainActivity();
                    }
                    else{
                        bookListFrag_portrait.notifyDataChanged();
                        System.out.println("DATA IN PORTRAIT MODE CHANGED");
                        backToMainActivity();
                    }
//                   System.out.println("Size data:  "+ApplicationClass.bookArrayList.size());
//
                }
            }

     });
    }

    private void backToMainActivity() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}


