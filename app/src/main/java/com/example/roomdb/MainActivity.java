package com.example.roomdb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewName;
    AutoCompleteTextView autoCompleteTextView;
    Spinner spinner;
    ArrayList<String> arrayList = new ArrayList<>();
    String[] arrayListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listViewName = findViewById(R.id.listViewId);
        autoCompleteTextView = findViewById(R.id.AC_TV_ID);
        spinner = findViewById(R.id.spinerId);
        arrayListName = getResources().getStringArray(R.array.array_department);

        //Auto Complete Text View
        ArrayAdapter<String> arrayAdapterAutoComplete = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayListName);
        this.autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapterAutoComplete);

        //Spinner
        ArrayAdapter<String> arrayAdapterSpiner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrayListName);
        spinner.setAdapter(arrayAdapterSpiner);

        //List View

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayListName);
        listViewName.setAdapter(arrayAdapter);

        listViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = arrayAdapter.getItem(position);
                String value1 = arrayListName[position];
                Toast.makeText(MainActivity.this, value1, Toast.LENGTH_SHORT).show();
            }
        });
    }
}