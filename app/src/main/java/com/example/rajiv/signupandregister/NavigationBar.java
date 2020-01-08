package com.example.rajiv.signupandregister;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationBar extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private static FragmentManager fragmentManager;
    private NavigationView navigationView;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        fragmentManager = getSupportFragmentManager();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nav_view);
        thread = new Thread() {

            public void run() {
                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.about_us:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new AboutUsFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                                break;
                            case R.id.sponsors:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new SponsorsFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                                break;
                            case R.id.contacts:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new ContactUsFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                                break;
                            case R.id.schedule:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new ScheduleFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                                break;
                            case R.id.live_updates:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new LiveUpdatesFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                                break;
                            case R.id.profile:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new ProfileFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                                break;
                            case R.id.map:
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new MapFragment(), null).commit();
                                drawerLayout.closeDrawer(Gravity.LEFT, true);
                        }
                        //Toast.makeText(getApplicationContext(), "Item touched is " + id, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        };
        thread.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
