package com.example.book_lib;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity implements BookAdapter.ItemClicked {
    TextView nameFrag,authorFrag,summaryFrag;
    ImageButton addBtn;
    static BookListFrag bookListFrag;
    static BookListFrag_Portrait bookListFrag_portrait;
    FragmentManager fragmentManager;


    public static final String EXTRA_SCREENMODE="com.example.book_lib.EXTRA_SCREENMODE";
    private int modeScreenNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager= this.getSupportFragmentManager();

        if (findViewById(R.id.landscape_layout)!=null) {

            nameFrag = findViewById(R.id.nameBookFrag);
            authorFrag = findViewById(R.id.authorFrag);
            summaryFrag = findViewById(R.id.summaryFrag);
            onItemClicked(0);

        }
        if (findViewById(R.id.landscape_layout)!=null)
        {
            System.out.println("Landscape mode");
            bookListFrag= (BookListFrag) fragmentManager.findFragmentById(R.id.listLandscape);
            System.out.println("BOOK LIST FRAG: "+ bookListFrag);
            bookListFrag_portrait= null;
            System.out.println("BOOK LIST FRAG PORTRAIT: "+ bookListFrag_portrait);
            /***************************************/
            addBtn=findViewById(R.id.addBtnLandscape);
            modeScreenNo=1;
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openAddItemIntent(modeScreenNo);
                }
            });

        }
        else {
            System.out.println("Portrait mode");
            bookListFrag= null;
            System.out.println("BOOK LIST FRAG: "+ bookListFrag);
            bookListFrag_portrait= (BookListFrag_Portrait) fragmentManager.findFragmentById(R.id.listPortrait);
            System.out.println("BOOK LIST FRAG PORTRAIT: "+ bookListFrag_portrait);
            /********************************************/
            addBtn=findViewById(R.id.addBtnPortrait);
            modeScreenNo=0;
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openAddItemIntent(modeScreenNo);
                }
            });
        }

    }

    private void openAddItemIntent(int i) {
        Intent intent=new Intent(this,addBook_activity.class);
        intent.putExtra(EXTRA_SCREENMODE,i);
        startActivity(intent);
    }


    @Override
    public void onItemClicked(int index) {
        nameFrag.setText(ApplicationClass.bookArrayList.get(index).getName());
        authorFrag.setText(ApplicationClass.bookArrayList.get(index).getAuthor());
        summaryFrag.setText(ApplicationClass.bookArrayList.get(index).getSummary());

    }
}
