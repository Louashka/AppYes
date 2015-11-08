package com.tataev.yes;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tataev.yes.R;

public class FragmentSpinnerAndButtons extends Fragment implements OnItemSelectedListener {

    final String LOG_TAG = "myLogs";
    @Override



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


        return inflater.inflate(R.layout.activity_fragment_spinner_and_buttons,null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        Spinner spinner = (Spinner) getView().findViewById(R.id.category_spinner);
        spinner.setOnItemSelectedListener(this);
        //spinner.setPrompt("ФИЛЬТР");
        //  spinner.setSelection();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.category_spinner_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        ImageView imageCard = (ImageView)getView().findViewById(R.id.imageCard);
        ImageView imageGrid = (ImageView)getView().findViewById(R.id.imageGrid);
        ImageView imageList = (ImageView)getView().findViewById(R.id.imageList);


        Log.d(LOG_TAG, "Fragment2 onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment2 onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment2 onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment2 onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment2 onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment2 onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment2 onDetach");
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        // parent.getItemAtPosition(pos)

        Toast.makeText(getContext(), "Position = " + pos, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }



}
