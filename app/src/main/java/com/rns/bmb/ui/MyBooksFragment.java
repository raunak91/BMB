package com.rns.bmb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.rns.bmb.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MyBooksFragment extends Fragment {
    ListView listViewReg;
    ArrayAdapter<String> listAdapter;
    Button btnAddBooks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_books, container, false);

        listViewReg = (ListView)rootView.findViewById(R.id.lv_my_books);
        btnAddBooks = (Button)rootView.findViewById(R.id.add_books);

        String[] books = new String[]{"LOTR", "LOTR II", "LOTR III"};
        displayBooks(books);


        btnAddBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBooksFragment.this.getActivity(), SaveBookActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
    public void displayBooks(String[] books){
        ArrayList<String> booksList = new ArrayList<String>();
        booksList.addAll( Arrays.asList(books) );

        listAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.simplerow, booksList);
        listViewReg.setAdapter(listAdapter);
    }

}
