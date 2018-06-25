package com.androidmads.fontutils;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ajts.androidmads.fontutils.FontUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String lato_light = "fonts/Lato-Light.ttf";
    public static String lato_regular = "fonts/Lato-Regular.ttf";
    public static String lato_bold = "fonts/Lato-Bold.ttf";

    Typeface typefaceBold, typefaceRegular, typefaceLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Views
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textview = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        RadioButton radioButton = findViewById(R.id.radio);
        CheckBox checkBox = findViewById(R.id.chkBox);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        typefaceBold = Typeface.createFromAsset(getAssets(), lato_bold);
        typefaceLight = Typeface.createFromAsset(getAssets(), lato_light);
        typefaceRegular = Typeface.createFromAsset(getAssets(), lato_regular);

        // Apply Fonts to Toolbar, NavigationView, Views
        FontUtils fontUtils = new FontUtils();
        fontUtils.applyFontToToolbar(toolbar, typefaceBold);
        fontUtils.applyFontToNavigationView(navigationView, typefaceLight);
        fontUtils.applyFontToView(textview, typefaceRegular);
        fontUtils.applyFontToView(editText, typefaceRegular);
        fontUtils.applyFontToView(radioButton, typefaceBold);
        fontUtils.applyFontToView(checkBox, typefaceLight);
        fontUtils.applyFontToTabLayout(tabLayout, typefaceLight);
        fontUtils.applyFontToRadioGroup(radioGroup, typefaceLight);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment(), "ONE");
        adapter.addFragment(new TabFragment(), "TWO");
        adapter.addFragment(new TabFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        FontUtils fontUtils = new FontUtils();
        fontUtils.applyFontToMenu(menu, typefaceBold);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
