package com.crazy16.algorithm_7_8;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestion4TV;
    private EditText mQuestion5ET;
    private TextView mQuestion5TV;
    private Button mQuestion5BTN;
    private EditText mQuestion6ET;
    private TextView mQuestion6TV;
    private Button mQuestion6BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        int i = question4(16, 35);
        mQuestion4TV.setText("c=" + i);
    }

    private int question4(int a, int b) {
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);
        String sumNum = "";
        sumNum += String.valueOf(b1.charAt(1));
        sumNum += String.valueOf(b1.charAt(0));
        sumNum += String.valueOf(a1.charAt(1));
        sumNum += String.valueOf(a1.charAt(0));
        return Integer.valueOf(sumNum);

    }

    private void initView() {
        mQuestion4TV = (TextView) findViewById(R.id.question4TV);
        mQuestion5ET = (EditText) findViewById(R.id.question5ET);
        mQuestion5ET.setOnClickListener(this);
        mQuestion5TV = (TextView) findViewById(R.id.question5TV);
        mQuestion5TV.setOnClickListener(this);
        mQuestion5BTN = (Button) findViewById(R.id.question5BTN);
        mQuestion5BTN.setOnClickListener(this);
        mQuestion6ET = (EditText) findViewById(R.id.question6ET);
        mQuestion6ET.setOnClickListener(this);
        mQuestion6TV = (TextView) findViewById(R.id.question6TV);
        mQuestion6TV.setOnClickListener(this);
        mQuestion6BTN = (Button) findViewById(R.id.question6BTN);
        mQuestion6BTN.setOnClickListener(this);
    }

    private int question5(int n) {
        int tao = 1;
        for (int i = 0; i < n - 1; i++) {

            tao = (tao + 1) * 2;
        }
        return tao;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.question5BTN:
                submit();
                break;
            case R.id.question6BTN:
                submit2();
                break;
        }
    }

    private void submit() {
        // validate
        String question5ETString = mQuestion5ET.getText().toString().trim();
        if (TextUtils.isEmpty(question5ETString)) {
            Toast.makeText(this, "question5ETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        int i = question5(Integer.valueOf(question5ETString));
        mQuestion5TV.setText("结果:" + i);
    }

    private int question6(int a) {
        int b = 0;
        while (a > 0) {
            b *= 10;
            b += a % 10;
            a /= 10;
        }
        return b;

    }

    private void submit2() {
        // validate
        String question6ETString = mQuestion6ET.getText().toString().trim();
        if (TextUtils.isEmpty(question6ETString)) {
            Toast.makeText(this, "question6ETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer integer = Integer.valueOf(question6ETString);
        if(integer == question6(integer)){
            mQuestion6TV.setText("是的");
        }else {
            mQuestion6TV.setText("不是的");

        }

    }
}
