package com.NITT.ECEA.Probe20;

import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NavigationBar extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private static FragmentManager fragmentManager;
    private NavigationView navigationView;
    TextView user_name_lay,probe_id_lay;
    Button logout_button;
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

        Intent i=getIntent();
        navigationView = findViewById(R.id.nav_view);
        logout_button=(Button) navigationView.getHeaderView(0).findViewById(R.id.logout);

        user_name_lay=(TextView) navigationView.getHeaderView(0).findViewById(R.id.user_name);
        user_name_lay.setText(i.getStringExtra("u_name"));
        probe_id_lay=(TextView) navigationView.getHeaderView(0).findViewById(R.id.probeid);
        probe_id_lay.setText(i.getStringExtra("probe_id"));
        String probe_id=i.getStringExtra("probe_id");
        String u_name=i.getStringExtra("u_name");
        String dept=i.getStringExtra("dept");
        String clg=i.getStringExtra("clg");
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new ProfileFragment(u_name,probe_id,clg,dept), null).commit();

        navigationView.setItemIconTintList(null);
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
    public void logout(View view)
    {
        Log.i("click","click");
        finish();
    }
    @Override
    public void onBackPressed()
    {
     if(drawerLayout.isDrawerOpen(GravityCompat.START))
         drawerLayout.closeDrawers();
     else
     {
         Toast nw=Toast.makeText(this,"Hit the logout button in the openable window to sign out",Toast.LENGTH_LONG);
         nw.setGravity(Gravity.CENTER,0,0);
         nw.show();
     }

    }
}
