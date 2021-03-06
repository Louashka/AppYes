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

public class BottomForMan extends AppCompatActivity {
    ListView lvBottomForMan;
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_for_man);


        getSupportActionBar().hide();
        
        lvBottomForMan = (ListView)findViewById(R.id.lvBottomForMan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bottomForMan,android.R.layout.simple_list_item_1);
        lvBottomForMan.setAdapter(adapter);


        lvBottomForMan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);

                switch (position){
                    case 0:
                        startActivity(new Intent(view.getContext(),BottomClothForMan.class));
                        break;
                    case 1:
                        startActivity(new Intent(view.getContext(),JeansForMan.class));
                        break;
                    case 2:
                        startActivity(new Intent(view.getContext(),MansUnderneathCloth.class));
                        break;
                    case 3:
                        startActivity(new Intent(view.getContext(),MansBathingSuit.class));
                        break;
                    case 4:
                        startActivity(new Intent(view.getContext(),MansSocks.class));
                        break;
                    case 5:
                        startActivity(new Intent(view.getContext(),MansWarmUnderCloth.class));
                        break;


                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bottom_for_man, menu);
        return true;
    }

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
