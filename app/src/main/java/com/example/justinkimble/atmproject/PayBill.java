package com.example.justinkimble.atmproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class PayBill extends AppCompatActivity {
    Button spendingPay, checkingPay, confirm;
    TextView bill, textView, textView2, textView3, textView4, spendingBal, checkingBal, amtText;
    EditText editText;
    String checking, spending, bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);

        textView4 = findViewById(R.id.work);
        amtText = findViewById(R.id.please);
        spendingPay = findViewById(R.id.spendingPay);
        checkingPay = findViewById(R.id.checkingPay);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        spendingBal = findViewById(R.id.spendingBal);
        checkingBal = findViewById(R.id.checkingBal);
        confirm = findViewById(R.id.confirm);
        bill = findViewById(R.id.bill);
        editText = findViewById(R.id.editText);

        Intent intent = getIntent();
        checking = intent.getStringExtra("Checking");
        spending = intent.getStringExtra("Spending");
        bills = intent.getStringExtra("Bill");

        checkingBal.setText(checking);
        spendingBal.setText(spending);
        bill.setText(bills);
    }

    public void payCheckingClicked(View v) {
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.VISIBLE);
        amtText.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        checkingBal.setVisibility(View.VISIBLE);
        spendingBal.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        confirm.setVisibility(View.VISIBLE);
    }

    public void paySpendingClicked(View v) {
        spendingBal.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        amtText.setVisibility(View.VISIBLE);
        confirm.setVisibility(View.VISIBLE);
        checkingBal.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
    }

    public void confirmClicked(View v) {
        if (checkingBal.isShown()) {
            String chk = checkingBal.getText().toString();
            //String bl = bill.getText().toString();
            int checkAmt = Integer.parseInt(chk);
            int billAmt = Integer.parseInt(bills);
            String trash = editText.getText().toString();
            int payAmt = Integer.parseInt(trash);
            int done = billAmt - payAmt;
            int lastCheck = checkAmt - payAmt;
            if (done >= 0 && lastCheck >= 0 && billAmt >= 0) {
                String done2 = String.valueOf(done);
                bill.setText(done2);
                checkingBal.setText(String.valueOf(lastCheck));
                String newChecking = String.valueOf(lastCheck);
                checking = newChecking;
                bills = String.valueOf(done);
                Toast.makeText(PayBill.this, "Transaction Complete! Accounts Payable: $" + String.valueOf(done), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PayBill.this,Main2Activity.class);
                setResult(2, intent);
                intent.putExtra("Checking", ""+checking);
                intent.putExtra("Spending", ""+spending);
                intent.putExtra("Bill", ""+bills);
                finish();
            }
            else
                Toast.makeText(PayBill.this, "Cannot complete transaction.", Toast.LENGTH_LONG).show();
        }
        else if (spendingBal.isShown()){
            String sp = spendingBal.getText().toString();
            //String bl = bill.getText().toString();
            int spendAmt = Integer.parseInt(sp);
            int billAmt = Integer.parseInt(bills);
            String trash = editText.getText().toString();
            int payAmt = Integer.parseInt(trash);
            int done = billAmt - payAmt;
            int lastCheck = spendAmt - payAmt;
            if (done >= 0 && lastCheck >= 0 && billAmt >= 0) {
                String done2 = String.valueOf(done);
                bill.setText(done2);
                checkingBal.setText(String.valueOf(lastCheck));
                String newSpend = String.valueOf(lastCheck);
                spending = newSpend;
                bills = String.valueOf(done);
                Toast.makeText(PayBill.this, "Transaction Complete! Accounts Payable: $" + String.valueOf(done), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PayBill.this,Main2Activity.class);
                setResult(2, intent);
                intent.putExtra("Checking", ""+checking);
                intent.putExtra("Spending", ""+spending);
                intent.putExtra("Bill", ""+bills);
                finish();
            }
            else
                Toast.makeText(PayBill.this, "Cannot complete transaction.", Toast.LENGTH_LONG).show();

        }

    }

}
