package com.example.daven.helloworld;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    int cnt = 0;
    private TextView firstTextView;
    private EditText emailEditText, passwordEditText;
    private Button register, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstTextView = (TextView) findViewById(R.id.hi);
        emailEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
        login = (Button) findViewById(R.id.button_login);
        register = (Button) findViewById(R.id.button_Register);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            DialogFragment myFragment = new MyDialogFragment();
            myFragment.show(getFragmentManager(), "theDialog");
            return true;
        } else if (id == R.id.exit_app){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void loginToWorld(View view){
        cnt++;
        String email = String.valueOf(emailEditText.getText());
        String password = String.valueOf(passwordEditText.getText());
        if (email.contains("@") == false){
            Toast.makeText(this, "invalid email", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals("kasCda84")){
            Toast.makeText(this, "welcome " + email, Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "wrong password", Toast.LENGTH_LONG).show();
        }
        /*if (cnt % 2 == 0){
            firstTextView.setText("Again");
        } else {
            firstTextView.setText("You Suck");
        }*/

    }

    public void randomRegister(View view) {
        Intent goSecondLayout = new Intent(this, RegisterScreen.class);
        final int result = 1;
        startActivityForResult(goSecondLayout, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String gotEmail = data.getStringExtra("NewEmail");
        emailEditText.setText(gotEmail);
        String gotPassword = data.getStringExtra("NewPass");
        passwordEditText.setText(gotPassword);
        firstTextView.setText("Welcome " + data.getStringExtra("NewName") + "!");
    }
}
