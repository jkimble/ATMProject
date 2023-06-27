package com.example.justinkimble.atmproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class withdrawalScreen extends AppCompatActivity {
    TextView checkingBal, spendingBal, textView, textView2, textView3;
    Button button, button2, confirm;
    EditText editText;
    String c;
    String s;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal_screen);

        checkingBal = findViewById(R.id.checkingBal);
        spendingBal = findViewById(R.id.spendingBal);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        confirm = findViewById(R.id.confirm);

        Intent intent = getIntent();
        c = intent.getStringExtra("Checking");
        s = intent.getStringExtra("Spending");

        checkingBal.setText(c);
        spendingBal.setText(s);

        checkingBal.setVisibility(View.INVISIBLE);
        spendingBal.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        confirm.setVisibility(View.INVISIBLE);
    }

    public void checkingClicked(View v) {
        textView2.setVisibility(View.INVISIBLE);
        checkingBal.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.VISIBLE);
        confirm.setVisibility(View.VISIBLE);
    }

    public void spendingClicked(View v) {
        textView3.setVisibility(View.VISIBLE);
        spendingBal.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.VISIBLE);
        confirm.setVisibility(View.VISIBLE);
    }

    public void confirmClicked(View v) {
        if (checkingBal.isShown()) {
            String trash = checkingBal.getText().toString();
            String trash2 = spendingBal.getText().toString();
            int checkAmt = Integer.parseInt(trash);
            String amt = editText.getText().toString();
            int wthAmt = Integer.parseInt(amt);
            int total = checkAmt - wthAmt;
            if (total >= 0) {
                String newTrash2 = String.valueOf(total);
                Intent intent = new Intent(withdrawalScreen.this, Main2Activity.class);intent.putExtra("Checking", "" +newTrash2);
                intent.putExtra("Spending",""+ trash2);
                intent.putExtra("Checking", ""+newTrash2);
                checkingBal.setText(String.valueOf(total));
                Toast.makeText(withdrawalScreen.this, "Transaction Complete! New Balance: $" + String.valueOf(total), Toast.LENGTH_LONG).show();
                setResult(0, intent);
                finish();
            }
            else {
                checkingBal.setText(trash);
                Toast.makeText(withdrawalScreen.this, "Cannot withdraw more than amount in balance.",Toast.LENGTH_LONG).show();
            }

        }

        else if (spendingBal.isShown()) {
            String trash = spendingBal.getText().toString();
            String trash2 = checkingBal.getText().toString();
            int spendAmt = Integer.parseInt(trash);
            String amt = editText.getText().toString();
            int wthAmt = Integer.parseInt(amt);
            int total = spendAmt - wthAmt;
            if (total >= 0) {
                String newTrash = String.valueOf(total);
                Intent intent = new Intent(withdrawalScreen.this, Main2Activity.class);
                intent.putExtra("Spending","" + newTrash);
                intent.putExtra("Checking", "" + trash2);
                checkingBal.setText(String.valueOf(total));
                Toast.makeText(withdrawalScreen.this, "Transaction Complete! New Balance: $" + String.valueOf(total), Toast.LENGTH_LONG).show();
                setResult(1, intent);
                finish();
            }
            else {
                checkingBal.setText(trash);
                Toast.makeText(withdrawalScreen.this, "Cannot withdraw more than amount in balance.",Toast.LENGTH_LONG).show();
            }

        }
        }
    }

