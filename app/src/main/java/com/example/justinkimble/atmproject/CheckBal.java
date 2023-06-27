package com.example.justinkimble.atmproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckBal extends AppCompatActivity {
    TextView textView1, textView2, textView3, savings, spending1, checking1;
    Button button, button2;
    String checking, spending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_bal);

        spending1 = findViewById(R.id.spending);
        checking1 = findViewById(R.id.checking);
        textView1 = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        Intent intent = getIntent();
        checking = intent.getStringExtra("Checking");
        spending = intent.getStringExtra("Spending");

        checking1.setText(checking);
        spending1.setText(spending);
    }

    public void withdrawalClicked(View v) {
        Intent intent = new Intent(CheckBal.this, withdrawalScreen.class);
        intent.putExtra("Checking",""+checking);
        intent.putExtra("Spending", ""+spending);
        startActivity(intent);
    }

    public void depositClicked(View v) {
       Intent intent = new Intent(CheckBal.this, depositScreen.class);
        intent.putExtra("Checking",""+checking);
        intent.putExtra("Spending", ""+spending);
        startActivity(intent);
    }
}
