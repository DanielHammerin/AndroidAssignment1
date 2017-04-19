package com.example.daniel.assignment1project;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCountries extends AppCompatActivity {

    public static ArrayList<String> entryArray = new ArrayList<>();

    public static final String FIRST_COLUMN = "First";
    public static final String SECOND_COLUMN = "Second";

    public static TextView countryText;
    public static ListView countryList;
    public static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_countries);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open();
            }
        });
        entryArray.add("Sweden, 1995");
        entryArray.add("Norway, 2012");
        entryArray.add("USA, 1876");
        entryArray.add("Argentina, 1989");

        countryText = (TextView) findViewById(R.id.country);
        countryList = (ListView) findViewById(R.id.country_list);
        countryList = (ListView) findViewById(R.id.country_list);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entryArray);
        countryList.setAdapter(adapter);
    }
    public boolean open() {
        Intent intent = new Intent(this, AddCountryActivity.class);
        startActivity(intent);
        return true;
    }
}
