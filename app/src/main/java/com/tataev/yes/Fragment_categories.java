package com.tataev.yes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;




/**
 * Created by Xava on 16.09.2015.
 */
public class Fragment_categories  extends Fragment implements View.OnClickListener {
     TextView menu_nov_tab;
     TextView nearby_nov_tab;
     TextView novelty_nov_tab;
     TextView favor_nov_tab;
     TextView reservation_nov_tab;
     TextView categories_nov_tab;
    SearchView searchView;

    final String LOG_TAG = "myLogs";


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "activity_fargment_categories  onAtach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "activity_fargment_categories onCreate");


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "activity_fargment_categories onCreateView");


        return inflater.inflate(R.layout.activity_fragment_categories,null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        menu_nov_tab = (TextView) getView().findViewById(R.id.menu_nov_tab);
        nearby_nov_tab = (TextView) getView().findViewById(R.id.nearby_nov_tab);
        novelty_nov_tab = (TextView) getView().findViewById(R.id.novelty_nov_tab);
        favor_nov_tab = (TextView) getView().findViewById(R.id.favor_nov_tab);
        reservation_nov_tab = (TextView) getView().findViewById(R.id.reservation_nov_tab);
        categories_nov_tab = (TextView) getView().findViewById(R.id.categories_nov_tab);
        searchView = (SearchView)getView().findViewById(R.id.searchCategory);
        searchView.setOnClickListener(this);

        menu_nov_tab.setOnClickListener(this);
        nearby_nov_tab.setOnClickListener(this);
        novelty_nov_tab.setOnClickListener(this);
        favor_nov_tab.setOnClickListener(this);
        reservation_nov_tab.setOnClickListener(this);
        categories_nov_tab.setOnClickListener(this);

        Log.d(LOG_TAG, "Fragment1 onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment1 onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment1 onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment1 onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment1 onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment1 onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment1 onDetach");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_nov_tab:
                v.getContext().startActivity(new Intent(this.menu_nov_tab.getContext(), MainActivity.class));
                break;
            case R.id.nearby_nov_tab:
                    v.getContext().startActivity(new Intent(this.nearby_nov_tab.getContext(), Reviews.class));
                break;
            case R.id.novelty_nov_tab:
                v.getContext().startActivity(new Intent(this.novelty_nov_tab.getContext(), Novelty.class));
                break;
            case R.id.favor_nov_tab:
                     v.getContext().startActivity(new Intent(this.favor_nov_tab.getContext(), Reviews.class));
                break;
            case R.id.reservation_nov_tab:
                v.getContext().startActivity(new Intent(this.reservation_nov_tab.getContext(), Reservation.class));
                break;
            case R.id.categories_nov_tab:
                v.getContext().startActivity(new Intent(this.categories_nov_tab.getContext(), Categories.class));
                break;
            case R.id.searchCategory:
                searchView.onActionViewExpanded();

        }
    }


}