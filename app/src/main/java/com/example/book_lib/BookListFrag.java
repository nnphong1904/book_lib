package com.example.book_lib;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link BookListFrag.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link BookListFrag#newInstance} factory method to
// * create an instance of this fragment.
// */
public class BookListFrag extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    public BookListFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_book_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.listBooks);
        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(this.getActivity(),2,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter=new BookAdapter(this.getActivity(),ApplicationClass.bookArrayList);
        recyclerView.setAdapter(myAdapter);

    }
    public void notifyDataChanged(){
        myAdapter.notifyDataSetChanged();
    }
}
