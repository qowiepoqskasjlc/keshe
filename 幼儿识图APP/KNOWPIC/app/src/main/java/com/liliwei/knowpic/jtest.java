package com.liliwei.knowpic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class jtest extends AppCompatActivity implements View.OnClickListener{
    private Button chinese;
    private Button english;
    private TextView chinesetext;
    private TextView englishitext;
    private TextView xuanzeceshi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        chinese=(Button) findViewById(R.id.chinese);
        english=(Button) findViewById(R.id.english);
        chinesetext=(TextView) findViewById(R.id.chinesetext);
        englishitext=(TextView) findViewById(R.id.englishtext);

        chinese.setOnClickListener(this);
        english.setOnClickListener(this);
        chinesetext.setOnClickListener(this);
        englishitext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chinese:
                Toast.makeText(this, "中文测试", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(this,jtestch.class);
                startActivity(intent1);
                break;
            case R.id.chinesetext:
                Toast.makeText(this, "中文测试", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(this,jtestch.class);
                startActivity(intent2);
                break;
            case R.id.english:
                Toast.makeText(this, "English Test", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(this,jtesten.class);
                startActivity(intent3);
                break;
            case R.id.englishtext:
                Toast.makeText(this, "English Test", Toast.LENGTH_SHORT).show();
                Intent intent4=new Intent(this,jtesten.class);
                startActivity(intent4);
                break;
        }

    }
}
