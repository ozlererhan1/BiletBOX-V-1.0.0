package com.erhanozler.BiletBOX;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import net.simplifiedcoding.bottomnavigationexample.R;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    // Sol Slider için Yapýlmýþ özel layout android.support.v4 ün içinde
    private DrawerLayout mDrawerLayout;

    // Sol Slider Açýldýðýnda Görünecek ListView
    private ListView mDrawerList;

    // Navigation Drawer nesnesini ActionBar'da gösterir.
    private ActionBarDrawerToggle mDrawerToggle;

    // ActionBar'ýn titlesi dinamik olarak deðiþecek draweri açýp kapattýkça
    private String mTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.container1);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close
        );
        // Başlangıç Fragmenti Olarak Home Fragmenti Yükle
        loadFragment(new HomeFragment());
        //---------------------------------------------------

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);




        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
    }


       // Bottom Bar Seçilen Alan için Oluşturulan Fragmenti ÇAğırma
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.Home_Navigation:
                fragment = new HomeFragment();
                break;

            case R.id.Search_Navigation:
                fragment = new SearchFragment();
                break;

            case R.id.Like_Navigation:
                fragment = new LikeFragment();
                break;

        }

        return loadFragment(fragment);
    }
    //---------------------------------------------------------------------------------------------------------------

    private boolean loadFragment(Fragment fragment) {
        //Fragment Değiştirme İşlemi BOTTOM NAVIGATION  için-------
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    private void setUpToolbar(){

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("         Bilet-BOX");
        toolbar.setSubtitle("           Banner");


    }
    private void setUpDrawer(){

        NavigationDrawerFragment navFragment= (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment);
        DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.container1);
        navFragment.setUpNavigationDrawer(drawerLayout, toolbar);

    }

}
