package com.tataev.yes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.tataev.yes.adapter.ReviewsAdapter;

import java.util.ArrayList;

public class Reviews extends AppCompatActivity implements View.OnClickListener {

    TextView menu_tab;
    TextView nearby_tab;
    TextView novelty_tab;
    TextView favor_tab;
    TextView reservation_tab;
    TextView categories_tab;
    ListView listViewReviews;

    ReviewsObject draft = new ReviewsObject();
    ArrayList<String> objectFeaturesDraft = new ArrayList<String>();
    ArrayList<String> objectSizeDraft = new ArrayList<String>();
    Bitmap imgDraft;
    ArrayList<ReviewsObject> RODraft = new ArrayList<ReviewsObject>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);

        menu_tab = (TextView)findViewById(R.id.menu_tab);
        nearby_tab = (TextView)findViewById(R.id.nearby_tab);
        novelty_tab = (TextView)findViewById(R.id.novelty_tab);
        favor_tab = (TextView)findViewById(R.id.favor_tab);
        reservation_tab = (TextView)findViewById(R.id.reservation_tab);
        categories_tab = (TextView)findViewById(R.id.categories_tab);
        listViewReviews = (ListView)findViewById(R.id.listViewReviews);

        menu_tab.setOnClickListener(this);
        nearby_tab.setOnClickListener(this);
        novelty_tab.setOnClickListener(this);
        favor_tab.setOnClickListener(this);
        reservation_tab.setOnClickListener(this);
        categories_tab.setOnClickListener(this);



        objectFeaturesDraft.add("2 футболки по цене 1!");
        objectFeaturesDraft.add("На любой случай");
        objectFeaturesDraft.add("100% хлопка");
        objectFeaturesDraft.add("Отлично комбинируется");
        objectFeaturesDraft.add("Просто незаменимая модель");

        objectSizeDraft.add("40/42(XS)");
        objectSizeDraft.add("44/46(S)");
        objectSizeDraft.add("48/50(M)");
        objectSizeDraft.add("52/54(L)");
        objectSizeDraft.add("56/58(XL)");
        objectSizeDraft.add("60/62(XXL)");

        imgDraft = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.novelty_draft);

        draft.setObjectImage(imgDraft);
        draft.setObjectType("Футболка");
        draft.setObjectCompany("Arizona");
        draft.setObjectNumber(375125341);
        draft.setObjectFeatures(objectFeaturesDraft);
        draft.setObjectColor("хаки + белый");
        draft.setObjectSize(objectSizeDraft);
        draft.setObjectPrice(1499.00);
        draft.setObjectFirstValue(45);
        draft.setObjectSecondValue(85);
        draft.setObjectThirdValue(73);

        RODraft.add(draft);

        ReviewsAdapter adapter = new ReviewsAdapter(this, RODraft);
        listViewReviews.setAdapter(adapter);
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
            case R.id.menu_tab:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nearby_tab:
//                startActivity(new Intent(this, Reviews.class));
                break;
            case R.id.novelty_tab:
                startActivity(new Intent(this, Novelty.class));
                break;
            case R.id.favor_tab:
//                startActivity(new Intent(this, Reviews.class));
                break;
            case R.id.reservation_tab:
                startActivity(new Intent(this, Reservation.class));
                break;
            case R.id.categories_tab:
                startActivity(new Intent(this, Categories.class));
                break;
            default:
                break;
        }
    }
}
