package com.liliwei.knowpic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button shuzi;
    private Button dongwu;
    private Button jiaotong;
    private Button shuiguo;
    private Button yanse;
    private Button xingzhuang;
    private Button ceshi;
    private TextView test;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shuzi=(Button)findViewById(R.id.shuzi);
        dongwu=(Button)findViewById(R.id.dongwu);
        jiaotong=(Button)findViewById(R.id.jiaotong);
        shuiguo=(Button) findViewById(R.id.shuiguo);
        yanse=(Button) findViewById(R.id.yanse);
        xingzhuang=(Button) findViewById(R.id.xingzhuang);
        ceshi=(Button)findViewById(R.id.ceshi);
        text1=(TextView) findViewById(R.id.text1);
        text2=(TextView) findViewById(R.id.text2);
        text3=(TextView) findViewById(R.id.text3);
        text4=(TextView) findViewById(R.id.text4);
        text5=(TextView) findViewById(R.id.text5);
        text6=(TextView) findViewById(R.id.text6);
        test=(TextView) findViewById(R.id.test);

        shuzi.setOnClickListener(this);
        dongwu.setOnClickListener(this);
        jiaotong.setOnClickListener(this);
        shuiguo.setOnClickListener(this);
        yanse.setOnClickListener(this);
        xingzhuang.setOnClickListener(this);
        ceshi.setOnClickListener(this);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);
        text5.setOnClickListener(this);
        text6.setOnClickListener(this);
        test.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.shuzi:
                Toast.makeText(this, "数字", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, jshuzi.class);
                startActivity(intent1);
                break;
            case R.id.dongwu:
                Toast.makeText(this, "动物", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, jdongwu.class);
                startActivity(intent2);
                break;
            case R.id.jiaotong:
                Toast.makeText(this, "交通工具", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, jjiaotong.class);
                startActivity(intent3);
                break;
            case R.id.shuiguo:
                Toast.makeText(this, "水果", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, jshuiguo.class);
                startActivity(intent4);
                break;
            case R.id.yanse:
                Toast.makeText(this, "颜色", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, jyanse.class);
                startActivity(intent5);
                break;
            case R.id.text1:
                Toast.makeText(this, "数字", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, jshuzi.class);
                startActivity(intent6);
                break;
            case R.id.xingzhuang:
                Toast.makeText(this, "形状", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, jxingzhuang.class);
                startActivity(intent7);
                break;
            case R.id.ceshi:
                Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
                Intent intent13 = new Intent(this, jtest.class);
                startActivity(intent13);
                break;
            case R.id.text2:
                Toast.makeText(this, "动物", Toast.LENGTH_SHORT).show();
                Intent intent8 = new Intent(this, jdongwu.class);
                startActivity(intent8);
                break;
            case R.id.text3:
                Toast.makeText(this, "水果", Toast.LENGTH_SHORT).show();
                Intent intent9 = new Intent(this, jshuiguo.class);
                startActivity(intent9);
                break;
            case R.id.text4:
                Toast.makeText(this, "交通工具", Toast.LENGTH_SHORT).show();
                Intent intent10 = new Intent(this, jjiaotong.class);
                startActivity(intent10);
                break;
            case R.id.text5:
                Toast.makeText(this, "颜色", Toast.LENGTH_SHORT).show();
                Intent intent11 = new Intent(this, jyanse.class);
                startActivity(intent11);
                break;
            case R.id.text6:
                Toast.makeText(this, "形状", Toast.LENGTH_SHORT).show();
                Intent intent12 = new Intent(this, jxingzhuang.class);
                startActivity(intent12);
                break;
            case R.id.test:
                Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
                Intent intent14 = new Intent(this, jtest.class);
                startActivity(intent14);
                break;
        }
    }


}