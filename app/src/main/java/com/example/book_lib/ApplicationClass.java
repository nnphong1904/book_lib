package com.example.book_lib;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
  public static ArrayList<Book> bookArrayList;
    @Override
    public void onCreate() {
        super.onCreate();
        bookArrayList=new ArrayList<>();
        bookArrayList.add(new Book("A Brief History of Time","Stephen Hawking","In the ten years since its publication in 1988,"));
        bookArrayList.add(new Book("Sad Cypress","Agatha Christie","This is an unusual Poirot series, in which there is a possible miscarriage of justice."));
        bookArrayList.add(new Book("The Girl on the Train","Paula Hawkins","Rachel catches the same commuter train every morning. She knows it will wait at"));
        bookArrayList.add(new Book("Angels & Demons","Dan Brown","World-renowned Harvard symbologist Robert Langdon is summoned to a Swiss"));
        bookArrayList.add(new Book("Shit My Dad Says","Justin Halperng","After being dumped by his longtime girlfriend,"));

    }
}
