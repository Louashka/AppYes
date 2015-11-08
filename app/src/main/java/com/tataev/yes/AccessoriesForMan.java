package com.tataev.yes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tataev.yes.R;

public class AccessoriesForMan extends AppCompatActivity {
ListView lvAccessoriesForMan;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories_for_man);


        getSupportActionBar().hide();

        lvAccessoriesForMan = (ListView)findViewById(R.id.lvAccessoriesForMan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.accessoriesForManArray,android.R.layout.simple_list_item_1);
        lvAccessoriesForMan.setAdapter(adapter);

        lvAccessoriesForMan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);

                switch (position){
                    case 0:
                        startActivity(new Intent(view.getContext(),MansHeadDress.class));
                        break;
                    case 1:
                        startActivity(new Intent(view.getContext(),MansScarf.class));
                        break;
                    case 2:
                        startActivity(new Intent(view.getContext(),Gloves.class));
                        break;
                    case 3:
                        startActivity(new Intent(view.getContext(),Belts.class));
                        break;
                    case 4:
                        startActivity(new Intent(view.getContext(),PorteMonnaieAndBags.class));
                        break;
                    case 5:
                        startActivity(new Intent(view.getContext(),TieAndHanky.class));
                        break;
                    case 6:
                        startActivity(new Intent(view.getContext(),MansJewelry.class));
                        break;
                    case 7:
                        startActivity(new Intent(view.getContext(),MansGlasses.class));
                        break;
                    case 8:
                        startActivity(new Intent(view.getContext(),MansBracelet.class));
                        break;





                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
