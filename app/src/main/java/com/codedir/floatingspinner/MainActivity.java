package com.codedir.floatingspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.codedir.library.InputSpinner;

public class MainActivity extends AppCompatActivity {

    private InputSpinner spinner;
    private ArrayAdapter<String> adapter;
    private String str[] = {"android", "ios", "windows"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (InputSpinner) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,str);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new InputSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelectedListener(String item, int selectedIndex) {
                Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
