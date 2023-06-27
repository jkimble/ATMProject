package com.example.justinkimble.atmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String spending;
    String checking;
    String bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button withdrawal;
        Button deposit;
        Button checkMoney;
        Button payBill;
        Button logOut;


        withdrawal = findViewById(R.id.withdrawal);
        deposit = findViewById(R.id.deposit);
        checkMoney = findViewById(R.id.checkMoney);
        payBill = findViewById(R.id.payBill);
        logOut = findViewById(R.id.logOut);

        spending = "450";
        checking = "2500";
        bill = "130";

    }

    public void logOutClicked(View v) {
        Toast.makeText(Main2Activity.this, "Logout Successful", Toast.LENGTH_LONG).show();
        finish();
    }

    public void checkMoneyClicked(View v) {
        //Intent intent = getIntent();
        //spending = intent.getStringExtra("Spending");
        //checking = intent.getStringExtra("Checking");
        Intent check = new Intent(Main2Activity.this,CheckBal.class);
        check.putExtra("Spending", "" +spending);
        check.putExtra("Checking", "" +checking);
        startActivity(check);
    }

    public void payBillClicked(View v) {
       //Intent intent = getIntent();
       //spending = intent.getStringExtra("Spending");
       //checking = intent.getStringExtra("Checking");
        Intent pay = new Intent(Main2Activity.this, PayBill.class);
       pay.putExtra("Checking", "" + checking);
       pay.putExtra("Spending","" + spending);
       pay.putExtra("Bill",""+bill);
        startActivityForResult(pay,2);
    }

        public void withdrawalClicked(View v) {
        Intent with = new Intent(Main2Activity.this, withdrawalScreen.class);
        with.putExtra("Checking", ""+checking);
        with.putExtra("Spending",""+spending);
        startActivityForResult(with, 0);
    }

    public void depositClicked(View v) {
        Intent dep = new Intent(Main2Activity.this, depositScreen.class);
        dep.putExtra("Checking", ""+checking);
        dep.putExtra("Spending",""+spending);
        startActivityForResult(dep, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == 0 || resultCode == 1) {
            checking = intent.getStringExtra("Checking");
            spending = intent.getStringExtra("Spending");
        }
        else if (resultCode == 2) {
            checking = intent.getStringExtra("Checking");
            spending = intent.getStringExtra("Spending");
            bill = intent.getStringExtra("Bill");
        }
    }
    }
