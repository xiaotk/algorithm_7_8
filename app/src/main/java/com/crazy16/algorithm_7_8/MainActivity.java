package com.crazy16.algorithm_7_8;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestion1TV;
    private TextView mQuestion2TV;
    private TextView mQuestion3TV;
    private Button mGoAlgorithm2;
    private EditText mQuestion2ET;
    private Button mQuestion2BTN;
    private EditText mQuestion3ET;
    private Button mQuestion3BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Integer integer = question1();
        mQuestion1TV.setText(integer + "");
    }

    private double question2(Integer n) {
        int sumNum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                sumNum += i;
            }
        }
        return Math.sqrt(sumNum);
    }

    private Integer question1() {
        int[] a = {3, 1, 4, 7, 2, 1, 1, 2, 2,3,3};
        int max = 1;
        int maxNum = 0;
        // 记录名次
        int num = 0;
        LinkedHashMap<Integer, Integer> numMap = new LinkedHashMap<>();
//        存放第一次出现位置
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            if (linkedHashMap.get(i1) == null) {
                num++;
                numMap.put(i1, num);
                linkedHashMap.put(i1, 1);
            } else {
                int i2 = linkedHashMap.get(i1) + 1;
                linkedHashMap.put(i1, i2);
                if(max < i2){
                    max = i2;
                    maxNum = i1;
                    numList.clear();
                    numList.add(i1);
                }else if(max == i2){
                    numList.add(i1);
                }

            }
        }
//        位置最小
        Integer min = null;
        Integer minNum = null;
        for (int i = 0; i < numList.size(); i++) {
            Integer integer = numList.get(i);
            boolean b = min == null;
            if (min == null || min > numMap.get(integer)) {
                min = numMap.get(integer);
                minNum = integer;
            }
        }

        return minNum;
    }

    private void initView() {
        mQuestion1TV = (TextView) findViewById(R.id.question1TV);
        mQuestion2TV = (TextView) findViewById(R.id.question2TV);
        mQuestion3TV = (TextView) findViewById(R.id.question3TV);
        mGoAlgorithm2 = (Button) findViewById(R.id.goAlgorithm2);

        mGoAlgorithm2.setOnClickListener(this);
        mQuestion2ET = (EditText) findViewById(R.id.question2ET);
        mQuestion2ET.setOnClickListener(this);
        mQuestion2BTN = (Button) findViewById(R.id.question2BTN);
        mQuestion2BTN.setOnClickListener(this);
        mQuestion3ET = (EditText) findViewById(R.id.question3ET);
        mQuestion3ET.setOnClickListener(this);
        mQuestion3BTN = (Button) findViewById(R.id.question3BTN);
        mQuestion3BTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goAlgorithm2:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.question2BTN:
                submit();
                break;
            case R.id.question3BTN:
                submit3();
                break;
        }
    }

    private void submit() {
        // validate
        String question2ETString = mQuestion2ET.getText().toString().trim();
        if (TextUtils.isEmpty(question2ETString)) {
            Toast.makeText(this, "question2ETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        double sqrt = question2(Integer.valueOf(question2ETString));
        mQuestion2TV.setText("平方根:" + sqrt);

    }

    public static long question3(long a) {
        if(a == 0){
            return 0;
        }
        return question3(a / 10) + a;
    }

    private void submit3() {
        // validate
        String question3ETString = mQuestion3ET.getText().toString().trim();
        if (TextUtils.isEmpty(question3ETString)) {
            Toast.makeText(this, "question3ETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Integer valueOf = Integer.valueOf(question3ETString);
        String sumString = "";
        for (int i = 0; i < valueOf; i++) {
            sumString += valueOf+"";
        }
        long l = question3(Long.valueOf(sumString));
        mQuestion3TV.setText("结果为：" + l);
    }
}
