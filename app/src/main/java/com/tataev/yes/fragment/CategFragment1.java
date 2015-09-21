package com.tataev.yes.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.tataev.yes.R;
import com.tataev.yes.adapter.NoveltyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategFragment1 extends Fragment {

    GridView gridViewNovelty;
    List<String> items = Arrays.asList("US $3.29", "US $2.59", "US $2.99", "US $2.36");

    public CategFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_categ_fragment1, container, false);

        gridViewNovelty = (GridView)rootView.findViewById(R.id.gridViewNovelty);
        NoveltyAdapter adapeter = new NoveltyAdapter(getActivity(), items);
        gridViewNovelty.setAdapter(adapeter);

        return rootView;
    }

}
