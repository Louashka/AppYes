package com.tataev.yes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.tataev.yes.adapter.UsersAdapter;
import com.tataev.yes.adapter.UsersSearchAdapter;

import java.util.ArrayList;

public class Users extends AppCompatActivity {

    public ExpandableListView exListView;
    public UsersSearchAdapter usersSearchAdapter;
    public ListView listViewUsers;
    public UsersAdapter usersAdapter;
    public ArrayList<UsersList> usersList = new ArrayList<UsersList>();
    public Bitmap bitmap;
    public ImageView imageRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.users_logo_default);
        usersList.add(new UsersList(bitmap, "Khasbulat Designer", true));
        usersList.add(new UsersList(bitmap, "Mikail Designer", false));
        usersList.add(new UsersList(bitmap, "Khasbulat Designer", true));
        usersList.add(new UsersList(bitmap, "Khasbulat Designer", false));
        usersList.add(new UsersList(bitmap, "Khasbulat Designer", false));

        imageRequest = (ImageView)findViewById(R.id.imageRequest);
        exListView = (ExpandableListView) findViewById(R.id.exListView);
        listViewUsers = (ListView)findViewById(R.id.listViewUsers);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            exListView.setIndicatorBounds(width-GetPixelFromDips(35), width-GetPixelFromDips(5));
        } else {
            exListView.setIndicatorBoundsRelative(width-GetPixelFromDips(35), width-GetPixelFromDips(5));
        }

        usersSearchAdapter = new UsersSearchAdapter(this);
        exListView.setAdapter(usersSearchAdapter);

        usersAdapter = new UsersAdapter(this, usersList);
        listViewUsers.setAdapter(usersAdapter);

        imageRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Users.this, Requests.class));
            }
        });

    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
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
