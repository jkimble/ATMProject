package com.example.justinkimble.atmproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText login;
    EditText password;
    TextView loginError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        loginError = findViewById(R.id.loginError);


    }

    public void submitClicked(View v) {
        if (login.length() <= 5 || password.length() <= 5) {
            loginError.setVisibility(View.VISIBLE);
        }


        else if (login.length() >= 6 && password.length() >= 6){
            login.setText("");
            password.setText("");
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
