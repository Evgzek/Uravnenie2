package com.example.uravnenie2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Static extends AppCompatActivity {
    private ExpandableListView list;
    String[] groups = {"Тема 1", "Тема 2"};
    ArrayList<String> numberTema1 = new ArrayList<>();
    Integer[] numberTema2 = {};
    // коллекция для групп
    ArrayList<Map<String, String>> groupData;
    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;
    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    // в итоге получится childData = ArrayList<childDataItem>
    Map<String, String> m;
    Map<String, String> i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);
        init();
        Start.sPref = getSharedPreferences("Save1", MODE_PRIVATE);
        if (Start.sPref.getStringSet(Start.SAVE_MASSIV, null) == null) {//проверка
        } else {
            load();
        }
        niceList(numberTema1);//список по умолчанию
    }

    public void init() {
        list = findViewById(R.id.list);
    }

    public void load() {
        Set<String> set = Start.sPref.getStringSet(Start.SAVE_MASSIV, null);
        numberTema1.addAll(set);//загружается статистика с папки сохранения
    }

    public void niceList(ArrayList<String> numberTema) {
        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // заполняем список атрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put("groupName", group);// имя компании
            groupData.add(m);
        }
        // список атрибутов групп для чтения
        String groupFrom[] = new String[]{"groupName"};
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[]{android.R.id.text1};
        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();
        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список атрибутов для каждого элемента
        for (String number : numberTema) {
            i = new HashMap<String, String>();
            i.put("numberTema", number);
            childDataItem.add(i);
        }
        childData.add(childDataItem);
        childDataItem = new ArrayList<Map<String, String>>();
        for (Integer number : numberTema2) {
            i = new HashMap<String, String>();
            i.put("numberTema", number.toString());
            childDataItem.add(i);
        }
        childData.add(childDataItem);
        // список атрибутов элементов для чтения
        String childFrom[] = new String[]{"numberTema"};
        // список ID view-элементов, в которые будет помещены атрибуты элементов
        int childTo[] = new int[]{android.R.id.text1};
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,//название темы
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,//статистика
                childFrom,
                childTo
        );
        list.setAdapter(adapter);

    }
}