package com.example.daniel.assignment1project;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class AddCountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.saveButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText country = (EditText) findViewById(R.id.visitedCountry);
                final EditText date = (EditText) findViewById(R.id.whenVisit);

                if (country.getText().toString().equals(null)) {
                    Toast.makeText(AddCountryActivity.this, "So, you didn't visit a country?", Toast.LENGTH_SHORT).show();
                }
                else if (date.getText().toString().equals(null)) {
                    Toast.makeText(AddCountryActivity.this, "No date?", Toast.LENGTH_SHORT).show();
                }
                else if (addEntry(country.getText().toString(), date.getText().toString())) {
                    Snackbar.make(view, "Saved!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {
                    Snackbar.make(view, "Something went wrong!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });
    }
    public boolean addEntry(String country, String date) {
        String newEntry;
        newEntry = country + ", " + date;
        MyCountries.entryArray.add(newEntry);
        MyCountries.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MyCountries.entryArray);
        MyCountries.countryList.setAdapter(MyCountries.adapter);
        MyCountries.adapter.notifyDataSetChanged();
        return true;
    }
}
