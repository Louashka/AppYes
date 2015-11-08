package com.tataev.yes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.tataev.yes.R;
import com.tataev.yes.adapter.SubCategoriesAdapter;
import com.tataev.yes.adapter.SubCategoriesAdapterCard;
import com.tataev.yes.adapter.SubCategoriesAdapterGrid;

import java.util.ArrayList;

public class BottomClothForMan extends AppCompatActivity implements  View.OnClickListener {

    ListView listView,listViewCard;
    ArrayList<Goods> listData;
    SubCategoriesAdapter adapter;
    SubCategoriesAdapterCard adapterCard;
    SubCategoriesAdapterGrid adapterGrid;
    GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_cloth_for_man);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);
        ab.setDisplayShowTitleEnabled(false);

        listView = (ListView) findViewById(R.id.listView);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setVisibility(View.GONE);
        listViewCard = (ListView)findViewById(R.id.listViewCard);
        listViewCard.setVisibility(View.GONE);

        ImageView imageCard = (ImageView)findViewById(R.id.imageCard);
        ImageView imageGrid = (ImageView)findViewById(R.id.imageGrid);
        ImageView imageList = (ImageView)findViewById(R.id.imageList);
        imageCard.setOnClickListener(this);
        imageGrid.setOnClickListener(this);
        imageList.setOnClickListener(this);



        listData = getData();
        if (listData !=null){
            adapter = new SubCategoriesAdapter(this,listData);
            listView.setAdapter(adapter);
            adapterGrid = new SubCategoriesAdapterGrid(this,listData);
            gridView.setAdapter(adapterGrid);
            adapterCard = new SubCategoriesAdapterCard(this,listData);
            listViewCard.setAdapter(adapterCard);
        }

        this.gridView = gridView;
        this.listView = listView;




    }

    public ArrayList<Goods> getData() {
        ArrayList<Goods> List = new ArrayList<>();

        Goods good1 = new Goods();
        good1.setTitle("Брюки");
        good1.setPrice("1500руб.");
        good1.setLastPrice("2000руб.");
        good1.setDiscount("-30%");
        good1.setAction("Акция!");
        good1.setFreeDelivering("Бесплатная доставка");
        good1.setTime("Время");
        good1.setOrdering("30 Бронь");
        good1.setNumOfSelled("50 продано");
        good1.setImageIcon(R.drawable.ic_pants);
        List.add(good1);

        Goods good2 = new Goods();
        good2.setTitle("Брюки");
        good2.setPrice("2000руб.");
        good2.setLastPrice("2500руб");
        good2.setDiscount("-30%");
        good2.setAction("Акция!");
        good2.setFreeDelivering("Бесплатная доставка");
        good2.setTime("Время");
        good2.setOrdering("30 Бронь");
        good2.setNumOfSelled("50 продано");
        good2.setImageIcon(R.drawable.ic_pants);
        List.add(good2);

        Goods good3 = new Goods();
        good3.setTitle("Брюки");
        good3.setPrice("3000руб");
        good3.setLastPrice("3500руб");
        good3.setDiscount("-30%");
        good3.setAction("Акция!");
        good3.setFreeDelivering("Бесплатная доставка");
        good3.setTime("Время");
        good3.setOrdering("30 Бронь");
        good3.setNumOfSelled("115 продано");
        good3.setImageIcon(R.drawable.ic_pants);
        List.add(good3);


        Goods good4 = new Goods();
        good4.setTitle("Брюки");
        good4.setPrice("1500");
        good4.setLastPrice("2000");
        good4.setDiscount("-30%");
        good4.setAction("Акция!");
        good4.setFreeDelivering("Бесплатная доставка");
        good4.setTime("Время");
        good4.setOrdering("30 Бронь");
        good4.setNumOfSelled("115 продано");
        good4.setImageIcon(R.drawable.ic_pants);
        List.add(good4);


        return List;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem navigation = menu.findItem(R.id.navigation);
        navigation.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=a+Grozniy");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                return true;
            }
        });

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


    public void onClick(View view) {


        switch (view.getId()){
            case R.id.imageCard:
                gridView.setVisibility(view.GONE);
                listView.setVisibility(view.GONE);
                listViewCard.setVisibility(View.VISIBLE);


                break;

            case R.id.imageGrid:
                gridView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                listViewCard.setVisibility(View.GONE);
                gridView.setNumColumns(GridView.AUTO_FIT);
                break;
            case R.id.imageList:
                gridView.setVisibility(View.GONE);
                listViewCard.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                break;
        }
    }


}
