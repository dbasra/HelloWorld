package com.example.daven.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Daven on 3/18/15.
 */
public class RegisterScreen extends Activity {
    private EditText emailAdd, password, name, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);
        emailAdd = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        name = (EditText) findViewById(R.id.editText3);
        confirmPassword = (EditText) findViewById(R.id.editText6);
    }

    public void registeredPerson(View view) {
        Intent goBack = new Intent(this, MainActivity.class);
        String actualName = String.valueOf(name.getText());
        String actualEmail = String.valueOf(emailAdd.getText());
        String actualPass = String.valueOf((password).getText());
        String confirmPass = String.valueOf(confirmPassword.getText());
        if (confirmPass.equals(actualPass)){
            goBack.putExtra("NewEmail", actualEmail);
            goBack.putExtra("NewPass", actualPass);
            goBack.putExtra("NewName", actualName);
            setResult(RESULT_OK, goBack);
            finish();
        } else {
            Toast.makeText(this, "The Passwords Do Not Match", Toast.LENGTH_LONG).show();
        }


    }
}
