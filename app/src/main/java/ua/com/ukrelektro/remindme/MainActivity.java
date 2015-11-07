package ua.com.ukrelektro.remindme;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter adapter;
    private TypedArray images;
    private Drawer result = null;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initImages();
        initToolbar();
        initListView();
        initNavDrawer(savedInstanceState);


    }

    private void initNavDrawer(Bundle savedInstanceState) {
        AccountHeader accountHeader = getAccountHeader();

        result = new DrawerBuilder(this)
                .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(accountHeader)
                .addDrawerItems(
                        getDrawerItems()
                )
                .withSavedInstance(savedInstanceState)
                .build();
    }

    @NonNull
    private IDrawerItem[] getDrawerItems() {
        return new IDrawerItem[]{new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(R.drawable.home).withBadge("99").withIdentifier(1),
                new PrimaryDrawerItem().withName(R.string.drawer_item_add).withIcon(R.drawable.plus_circle),
                new PrimaryDrawerItem().withName(R.string.drawer_item_search).withIcon(R.drawable.magnify).withBadge("6").withIdentifier(2),
                new SectionDrawerItem().withName(R.string.drawer_item_tags),
                new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(R.drawable.help_circle),
                new SecondaryDrawerItem().withName(R.string.drawer_item_about).withIcon(R.drawable.information),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(R.drawable.settings).withBadge("12+").withIdentifier(1)};
    }

    private AccountHeader getAccountHeader() {
        IProfile profile = new ProfileDrawerItem()
                .withName(InitUtil.getUserName())
                .withEmail(InitUtil.getEmail())
                .withIcon(InitUtil.getIcon());


        return new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(profile)
                .build();
    }

    private void initListView() {
        listView = (ListView) findViewById(R.id.list);

        // инициализация нашего адаптера
        adapter = new ListViewAdapter(this, initData());
        listView.setAdapter(adapter);

    }

    private ArrayList<ReminderObject> initData() {
        ArrayList<ReminderObject> reminderObjects = new ArrayList<>();
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
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


}
