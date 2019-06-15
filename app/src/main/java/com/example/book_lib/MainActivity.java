package com.example.book_lib;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity implements BookAdapter.ItemClicked {
    TextView nameFrag,authorFrag,summaryFrag;
    VideoView player;
    Uri uri;
    boolean isContinouly=false;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.landscape_layout)!=null) {
            System.out.println("Landscape mode");
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
