package com.tataev.yes;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView reviews_text;
    TextView novelty_text;
    TextView profile_text;
    TextView users_text;
    TextView categories_text;
    TextView rating_text;
    TextView discuss_text;
    TextView reservation_text;
    TextView abProg_text;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);
        ab.setDisplayShowTitleEnabled(false);

        searchView = (SearchView) findViewById(R.id.search_view_main);
        searchView.setQueryHint(getResources().getString(R.string.search_hint));

        reviews_text = (TextView)findViewById(R.id.reviews_text);
        novelty_text = (TextView)findViewById(R.id.novelty_text);
        profile_text = (TextView)findViewById(R.id.profile_text);
        users_text = (TextView)findViewById(R.id.users_text);
        categories_text = (TextView)findViewById(R.id.categories_text);
        rating_text = (TextView)findViewById(R.id.rating_text);
        discuss_text = (TextView)findViewById(R.id.discuss_text);
        reservation_text = (TextView)findViewById(R.id.reservation_text);
        abProg_text = (TextView)findViewById(R.id.abProg_text);

        reviews_text.setOnClickListener(this);
        novelty_text.setOnClickListener(this);
        profile_text.setOnClickListener(this);
        users_text.setOnClickListener(this);
        categories_text.setOnClickListener(this);
        rating_text.setOnClickListener(this);
        discuss_text.setOnClickListener(this);
        reservation_text.setOnClickListener(this);
        abProg_text.setOnClickListener(this);

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
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reviews_text:
                startActivity(new Intent(this, Reviews.class));
                break;
            case R.id.novelty_text:
                startActivity(new Intent(this, Novelty.class));
                break;
            case R.id.profile_text:
                startActivity(new Intent(this, Profile.class));
                break;
            case R.id.users_text:
                startActivity(new Intent(this, Users.class));
                break;
            case R.id.categories_text:
                startActivity(new Intent(this, Categories.class));
                break;
            case R.id.rating_text:
                startActivity(new Intent(this, Rating.class));
                break;
            case R.id.discuss_text:
                startActivity(new Intent(this, Discussions.class));
                break;
            case R.id.reservation_text:
                startActivity(new Intent(this, Reservation.class));
                break;
            case R.id.abProg_text:
                startActivity(new Intent(this, AboutProgram.class));
                break;
            default:
                break;
        }
    }
}
