package com.tataev.yes.adapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.SimpleExpandableListAdapter;

import com.tataev.yes.R;

public class CategoriesAdapter extends AppCompatActivity {

    final String ATTR_GROUP_NAME= "groupName";
    final String ATTR_PHONE_NAME= "childName";



    String[] groups = new String[] {"Одежда для мужчин", "Одежда для женщин", "Детские товары"};

    // названия телефонов (элементов)
    String[] mansCloth = new String[] {"Верх", "Низ", "Верхняя одежда", "Педжаки и костюмы","Спортивная одежда"
            ,"Домашняя одежда","Плавки и пляжные шорты","Аксессуары"};
    String[] womanCloth = new String[] {"Популярные товары", "Низ","Верхняя одежда", "Свадебные и торжественные платья",
            "Нижнее бельё","Домашняя одежда ","Спортивная одежда","Одежда для беременных", "Аксессуары"};
    String[] childGoods = new String[] {"Для Ново-рожденных","Одежда для девочек","Для девушек", "Одежда для мальчиков",
           "Для юношей","Школа", "Аксессуары"};


    /*
Resources res = getResources();
   // названия компаний (групп)
    String[] groups =  res.getStringArray(R.array.categories_items);

    // названия телефонов (элементов)
    String[] mansCloth = res.getStringArray(R.array.mansCloth);
    String[] womanCloth = res.getStringArray(R.array.womanCloth);
    String[] childGoods  = res.getStringArray(R.array.childGoods);
**/

    // коллекция для групп
    ArrayList<Map<String, String>> groupData;

    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;

    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    // в итоге получится childData = ArrayList<childDataItem>

    // список аттрибутов группы или элемента
    Map<String, String> m;

    Context ctx;

    public CategoriesAdapter(Context _ctx) {
        ctx = _ctx;
    }

    SimpleExpandableListAdapter adapter;


    public SimpleExpandableListAdapter getAdapter() {

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // заполняем список аттрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put(ATTR_GROUP_NAME, group); // имя компании
            groupData.add(m);
        }

        // список аттрибутов групп для чтения
        String groupFrom[] = new String[] {ATTR_GROUP_NAME};
        // список ID view-элементов, в которые будет помещены аттрибуты групп
        int groupTo[] = new int[] {android.R.id.text1};


        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список аттрибутов для каждого элемента
        for (String manscloth : mansCloth) {
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, manscloth); // название телефона
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для второй группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String womancloth : womanCloth) {
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, womancloth);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // создаем коллекцию элементов для третьей группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String childgoods :childGoods) {
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, childgoods);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // список аттрибутов элементов для чтения
        String childFrom[] = new String[] {ATTR_PHONE_NAME};
        // список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[] {android.R.id.text1};

        adapter = new SimpleExpandableListAdapter(
                ctx,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo);

        return adapter;
    }

    public String getGroupText(int groupPos) {
        return ((Map<String,String>)(adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }

    String getChildText(int groupPos, int childPos) {
        return ((Map<String,String>)(adapter.getChild(groupPos, childPos))).get(ATTR_PHONE_NAME);
    }

    public String getGroupChildText(int groupPos, int childPos) {
        return getGroupText(groupPos) + " " +  getChildText(groupPos, childPos);
    }
}
