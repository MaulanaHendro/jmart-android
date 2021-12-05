package com.MaulanaNurhendronotoJmartAK.jmart_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager view_Pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_Layout);
        view_Pager = findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(view_Pager);

        AdapterFragment vpAdapter = new AdapterFragment(getSupportFragmentManager(), AdapterFragment.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new ProductFragment(), "Product");
        vpAdapter.addFragment(new FilterFragment(), "Filter");
        view_Pager.setAdapter(vpAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.person) {
            Toast.makeText(this, "Account Selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.add) {
            Toast.makeText(this, "Create Product Selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, CreateProductActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}