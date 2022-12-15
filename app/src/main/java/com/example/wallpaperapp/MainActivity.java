package com.example.wallpaperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    int []arr={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
            R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,R.drawable.pic10,R.drawable.pic11};

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(arr);

        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setHasFixedSize(true);


    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}