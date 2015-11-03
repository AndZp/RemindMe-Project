package ua.com.ukrelektro.remindme;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by User on 03.11.2015.
 */
public class MainActivity extends Activity {
    private ListView listView;
    private ListViewAdapter adapter;
    private TypedArray images;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initImages();
        initToolbar();
        initListView();
    }

    private void initListView() {
        listView = (ListView) findViewById(R.id.list);

        // инициализация нашего адаптера
        adapter = new ListViewAdapter(this, initData());
        listView.setAdapter(adapter);

    }

    private ArrayList<ReminderObject> initData() {
        ArrayList<ReminderObject> reminderObjects = new ArrayList<ReminderObject>();
        reminderObjects.add(new ReminderObject("Do cool app", Tags.Work));
        reminderObjects.add(new ReminderObject("Go to Bar", Tags.Rest));
        reminderObjects.add(new ReminderObject("Learn all Android SDK", Tags.Learn));
        reminderObjects.add(new ReminderObject("My birthday", Tags.BirthDay));
        reminderObjects.get(2).setStatus(true);
        reminderObjects.get(3).setStatus(true);
        reminderObjects.add(new ReminderObject("Find job", Tags.Work));
        reminderObjects.add(new ReminderObject("Go to Bar again", Tags.Rest));
        reminderObjects.add(new ReminderObject("Learn all C#", Tags.Learn));
        reminderObjects.add(new ReminderObject("My birthday", Tags.BirthDay));
        return reminderObjects;
    }


    // Инициализируем изображения с помощью ресурса изображений
    // данный ресурс будет рассмотрен ниже
    private void initImages() {
        Resources res = getResources();
        images = res.obtainTypedArray(R.array.images);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }


}
