package com.tataev.yes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.tataev.yes.adapter.CategoriesAdapter;


public class Categories  extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    ExpandableListView elvMain;
    CategoriesAdapter  ah;
    SimpleExpandableListAdapter adapter;
    TextView tvInfo;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);
        ab.setDisplayShowTitleEnabled(false);


        tvInfo = (TextView) findViewById(R.id.tvInfo);

        // создаем адаптер
        ah = new CategoriesAdapter(this);
        adapter = ah.getAdapter();

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);
        elvMain.setOnGroupExpandListener(new OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousGroup)
                    elvMain.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

        // нажатие на элемент
        elvMain.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition,   int childPosition, long id) {
                Log.d(LOG_TAG, "onChildClick groupPosition = " + groupPosition +
                        " childPosition = " + childPosition +
                        " id = " + id);


                switch (groupPosition ){
                    case 0:
                        if (childPosition ==0) {
                            startActivity(new Intent(v.getContext(), UpClothForMan.class));
                        }
                        if (childPosition == 1){
                            startActivity(new Intent(v.getContext(),BottomForMan.class));
                        }
                        if (childPosition== 2){
                            startActivity(new Intent(v.getContext(), JacetsAndCoats.class));
                        }
                        if (childPosition == 3){
                            startActivity(new Intent(v.getContext(),MansSuitAndBlazers.class));
                        }
                        if (childPosition == 4){
                            startActivity(new Intent(v.getContext(),SportWear.class));
                        }
                        if (childPosition == 5){
                            startActivity(new Intent(v.getContext(),IndoorClothing.class));
                        }

                        if (childPosition == 6){
                            startActivity(new Intent(v.getContext(),TrunksAndShort.class));
                        }
                        if (childPosition == 7){
                            startActivity(new Intent(v.getContext(),AccessoriesForMan.class));
                        }
                       break;
                    case 1:
                        if (childPosition ==0) {
                            startActivity(new Intent(v.getContext(), PopularForWoman.class));
                        }
                        if (childPosition == 1){
                            startActivity(new Intent(v.getContext(),BottomForWoman.class));
                        }
                        if (childPosition== 2){
                            startActivity(new Intent(v.getContext(),TopForWoman.class));
                        }
                        if (childPosition == 3){

                            startActivity(new Intent(v.getContext(),WeddingAndCelebrity.class));
                        }
                        if (childPosition == 4){
                            startActivity(new Intent(v.getContext(),WomansUnderCloth.class));
                        }
                        if (childPosition == 5){
                            startActivity(new Intent(v.getContext(),WomansIndoorCloth.class));
                        }
                        if (childPosition == 6){
                            startActivity(new Intent(v.getContext(),WomanSportwear.class));

                        }
                        if (childPosition == 7){
                            startActivity(new Intent(v.getContext(),PregnantWear.class));
                        }
                        if (childPosition == 8){
                            startActivity(new Intent(v.getContext(),WomanAccessory.class));
                        }
                        break;
                    case 2:
                        if (childPosition ==0) {
                            startActivity(new Intent(v.getContext(),BabiesGoods.class));

                        }
                        if (childPosition == 1){
                            startActivity(new Intent(v.getContext(),GirlieGoods.class));

                        }
                        if (childPosition== 2){
                            startActivity(new Intent(v.getContext(), GirlsGoods.class));

                        }
                        if (childPosition == 3){
                            startActivity(new Intent(v.getContext(),BoyGoods.class));

                        }
                        if (childPosition == 4){
                            startActivity(new Intent(v.getContext(),JuniorGoods.class));

                        }
                        if (childPosition == 5){
                            startActivity(new Intent(v.getContext(),SchoolGoods.class));

                        }
                        if (childPosition == 6){
                            startActivity(new Intent(v.getContext(),ChildAccessories.class));

                        }


                }
               tvInfo.setText(ah.getGroupChildText(groupPosition, childPosition));
                return false;
            }
        });

        // нажатие на группу
        elvMain.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Log.d(LOG_TAG, "onGroupClick groupPosition = " + groupPosition +
                        " id = " + id);
                // блокируем дальнейшую обработку события для группы с позицией 1
                if (groupPosition == 1) return false;

                return false;
            }
        });

        // сворачивание группы
        elvMain.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            public void onGroupCollapse(int groupPosition) {
                Log.d(LOG_TAG, "onGroupCollapse groupPosition = " + groupPosition);
                tvInfo.setText("Свернули " + ah.getGroupText(groupPosition));
            }
        });

        // разворачивание группы
        elvMain.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            public void onGroupExpand(int groupPosition) {
                Log.d(LOG_TAG, "onGroupExpand groupPosition = " + groupPosition);
                tvInfo.setText("Равзвернули " + ah.getGroupText(groupPosition));
            }
        });

        // разворачиваем группу с позицией 2
       // elvMain.expandGroup(2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem shareItem = menu.findItem(R.id.share);
        shareItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return true;
            }

        });




        final MenuItem navigation = menu.findItem(R.id.navigation);
        navigation.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Uri gmmIntentUri =  Uri.parse("geo:0,0?q=a+Grozniy");
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


}