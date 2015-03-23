package com.example.daven.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Daven on 3/23/15.
 */
public class AfterLoginScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);
        String [] options = {"Food", "Fun", "Studying", "Meeting", "Blah", "Blah", "Blah", "Blah",
                                "Blah", "Blah", "Blah", "Blah"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.youSuck, options);
        ListView theView = (ListView) findViewById(R.id.wordUp);
        theView.setAdapter(theAdapter);
        theView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String optionChosen = "You picked " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(AfterLoginScreen.this, optionChosen, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
