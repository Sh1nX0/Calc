package com.example.myapplication2h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNum1;
    EditText etNum2;
    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnidk;
    Button btnw;
    Button btnst;
    Button btnDoll;
    Button btnTeng;
    LinearLayout linearLayout;
    TextView tvResult;
    String oper = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnSub = findViewById(R.id.btnSub);
        btnidk = findViewById(R.id.btnidk);
        btnw = findViewById(R.id.btnw);
        btnst = findViewById(R.id.btnst);
        btnDoll = findViewById(R.id.btnDoll);
        btnTeng = findViewById(R.id.btnTeng);
        tvResult = findViewById(R.id.tvResult);
        linearLayout = findViewById(R.id.linearlayout);
        btnAdd.setOnClickListener((View.OnClickListener) this);
        btnMult.setOnClickListener((View.OnClickListener) this);
        btnSub.setOnClickListener((View.OnClickListener) this);
        btnDiv.setOnClickListener((View.OnClickListener) this);
        btnidk.setOnClickListener((View.OnClickListener) this);
        btnw.setOnClickListener((View.OnClickListener) this);
        btnst.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                if (num2 == 0) {
                    Toast.makeText(this, "Делить на ноль нельзя !", Toast.LENGTH_LONG).show();
                    result = 0;
                    break;
                }
                result = num1 / num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDoll:
                oper = "$";
                num2=0;
                result = num1 / 467 ;
                break;
            case R.id.btnTeng:
                oper = "T";
                result = num1 * 467 ;
                break;
            case R.id.btnidk:
                oper = "%";
                result = num1 % num2;
                break;
            case R.id.btnw:
                oper = "@";
                result = (num1 + num2) / 2;
                break;
            case R.id.btnst:
                oper = "^";
                result = (float) Math.pow(num1, num2);
                break;
        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Reset");
        menu.add(0, 2, 0, "Quit");
        menu.add(0, 3, 0, "another one");
        menu.add(0, 4, 0, "and another one");
        menu.add(0, 5, 0, "black");
        menu.add(0, 6, 0, "white");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                btnidk.setVisibility(View.INVISIBLE);
                btnw.setVisibility(View.INVISIBLE);
                break;
            case 2:
                finish();
                break;
            case 3:
                btnidk.setVisibility(View.VISIBLE);
                break;
            case 4:
                btnw.setVisibility(View.VISIBLE);
                break;
            case 5:
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
            case 6:
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }
        return super.onOptionsItemSelected(item);
    }
}