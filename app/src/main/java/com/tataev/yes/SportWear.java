package com.tataev.yes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tataev.yes.R;

public class SportWear extends AppCompatActivity {
    ListView lvSportWear;
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_wear);
        getSupportActionBar().hide();

        lvSportWear = (ListView)findViewById(R.id.lvSportWear);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sportWearArray,android.R.layout.simple_list_item_1);
        lvSportWear.setAdapter(adapter);

        lvSportWear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);

                switch (position){
                    case 0:
                        startActivity(new Intent(view.getContext(),SportJackets.class));
                        break;
                    case 1:
                        startActivity(new Intent(view.getContext(),SportsPants.class));
                        break;
                    case 2:
                        startActivity(new Intent(view.getContext(),HoodedJacket.class));
                        break;
                    case 3:
                        startActivity(new Intent(view.getContext(),SportSuits.class));
                        break;
                    case 4:
                        startActivity(new Intent(view.getContext(),PantsWithFleece.class));
                        break;
                }



            }
        });


    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sport_wear, menu);
        return true;
    }
**/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
