package com.example.daven.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by Daven on 3/23/15.
 */
public class AfterLoginScreen extends Activity{
    private NumberPicker min, hour, sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);

    }

    public void goToSoloPage(View view) {

        Intent goSoloPage = new Intent(this, SoloScreen.class);
        startActivity(goSoloPage);
    }
}
