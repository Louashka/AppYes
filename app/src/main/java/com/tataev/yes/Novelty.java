package com.tataev.yes;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.tataev.yes.fragment.CategFragment1;
import com.viewpagerindicator.TabPageIndicator;

public class Novelty extends AppCompatActivity implements View.OnClickListener{

    private static String[] CONTENT;
    TextView menu_nov_tab;
    TextView nearby_nov_tab;
    TextView novelty_nov_tab;
    TextView favor_nov_tab;
    TextView reservation_nov_tab;
    TextView categories_nov_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novelty);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);

        CONTENT = getResources().getStringArray(R.array.categories_items);

        menu_nov_tab = (TextView)findViewById(R.id.menu_nov_tab);
        nearby_nov_tab = (TextView)findViewById(R.id.nearby_nov_tab);
        novelty_nov_tab = (TextView)findViewById(R.id.novelty_nov_tab);
        favor_nov_tab = (TextView)findViewById(R.id.favor_nov_tab);
        reservation_nov_tab = (TextView)findViewById(R.id.reservation_nov_tab);
        categories_nov_tab = (TextView)findViewById(R.id.categories_nov_tab);

        menu_nov_tab.setOnClickListener(this);
        nearby_nov_tab.setOnClickListener(this);
        novelty_nov_tab.setOnClickListener(this);
        favor_nov_tab.setOnClickListener(this);
        reservation_nov_tab.setOnClickListener(this);
        categories_nov_tab.setOnClickListener(this);

        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_nov_tab:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nearby_nov_tab:
//                startActivity(new Intent(this, Reviews.class));
                break;
            case R.id.novelty_nov_tab:
                startActivity(new Intent(this, Novelty.class));
                break;
            case R.id.favor_nov_tab:
//                startActivity(new Intent(this, Reviews.class));
                break;
            case R.id.reservation_nov_tab:
                startActivity(new Intent(this, Reservation.class));
                break;
            case R.id.categories_nov_tab:
                startActivity(new Intent(this, Categories.class));
                break;
            default:
                break;
        }
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new CategFragment1();
                    break;
                default:
                    fragment = new CategFragment1();
                    break;
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}
