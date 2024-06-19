package com.example.login_page3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView create_account;
    CardView card_walking,card_boat,card_bus,card_train,card_cycle,card_plane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        create_account = findViewById(R.id.create_account);

        card_walking = findViewById(R.id.card_walking);
        card_boat = findViewById(R.id.card_boat);
        card_bus = findViewById(R.id.card_bus);
        card_train = findViewById(R.id.card_train);
        card_cycle = findViewById(R.id.card_cycle);
        card_plane = findViewById(R.id.card_plane);



        card_walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(MainActivity.this,walk.class);
                startActivity(i6);
            }
        });

        card_boat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(MainActivity.this,boat.class);
                startActivity(i7);
            }
        });
        card_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8 = new Intent(MainActivity.this,Bus.class);
                startActivity(i8);
            }
        });
        card_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i9 = new Intent(MainActivity.this,train.class);
                startActivity(i9);
            }
        });
        card_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10 = new Intent(MainActivity.this,Cycle.class);
                startActivity(i10);
            }
        });
        card_plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i11 = new Intent(MainActivity.this,Plane.class);
                startActivity(i11);
            }
        });




        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(MainActivity.this,Create_Profile.class);
                startActivity(i5);
            }
        });


        setSupportActionBar(toolbar);


        Menu menu = navigationView.getMenu();
        //menu.findItem(R.id.nav_logout).setVisible(false);
        //menu.findItem(R.id.nav_profile).setVisible(false);

        navigationView.bringToFront();

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_drawer_open,R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {



        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_bus:
                Intent i1 = new Intent(MainActivity.this,Bus.class);
                startActivity(i1);
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_Register:
                Intent i2 = new Intent(MainActivity.this,sign_up.class);
                startActivity(i2);
                break;

            case R.id.nav_logout:
                Intent i3 = new Intent(MainActivity.this,log_in.class);
                startActivity(i3);
                break;
            case R.id.nav_cycle:
                Intent i4 = new Intent(MainActivity.this,Cycle.class);
                startActivity(i4);
                break;

            case R.id.nav_plane:
                Intent i5 = new Intent(MainActivity.this,Plane.class);
                startActivity(i5);
                break;
            case R.id.nav_profile:
                Intent i6 = new Intent(MainActivity.this,Create_Profile.class);
                startActivity(i6);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}