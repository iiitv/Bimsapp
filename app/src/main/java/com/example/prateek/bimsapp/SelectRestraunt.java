package com.example.prateek.bimsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.vision.text.Line;

public class SelectRestraunt extends AppCompatActivity {
    StoreSharedPreferences storeSharedPreferences = new StoreSharedPreferences();

    LinearLayout bims, midnight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_restraunt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bims = (LinearLayout)findViewById(R.id.bimsKitchen);
        midnight = (LinearLayout)findViewById(R.id.midnightScorer);

        bims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeSharedPreferences.setKitchenDatabase(getApplicationContext(), "email");
                Toast.makeText(getApplicationContext(), "bims", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SelectRestraunt.this, MenuMain.class);
                startActivity(i);
            }
        });
        midnight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeSharedPreferences.setKitchenDatabase(getApplicationContext(), "kuch bhi");
                Toast.makeText(getApplicationContext(), "Midnight", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SelectRestraunt.this, MenuMain.class);
                startActivity(i);
            }
        });
    }

    public void goToRestraunt(View view) {
        Intent i = new Intent(SelectRestraunt.this, MenuMain.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.select_restraunt_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.changeNumber:
                changeNumber();
                return true;
            case R.id.signOut:
                signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeNumber(){
        //implement later
    }

    public void signOut(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
        //also remove the shared preferences
    }
}
