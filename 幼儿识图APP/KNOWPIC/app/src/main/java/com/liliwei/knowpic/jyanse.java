package com.liliwei.knowpic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class jyanse extends AppCompatActivity implements View.OnClickListener{
    private Button zuo;
    private Button you;
    private Button ch1;
    private Button eh1;
    private Button auto;
    private Button zhuye;
    private TextView renshi;
    private ImageView yanse;
    private LinearLayout ground;
    private boolean aflag=false;
    private MediaPlayer mediaPlayer;
    private int[] photos = {R.drawable.hongse, R.drawable.chengse, R.drawable.huangse,
            R.drawable.lvse, R.drawable.lanse,R.drawable.zise,R.drawable.fense,
            R.drawable.heise};

    private int photoIndex = 0;
    private int maxIndex = 7;
    static Handler handler =new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            {
                yanse = (ImageView) findViewById(R.id.yanse);
                switch (photoIndex) {
                    case 0: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_hongse);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_hongse);
                        mediaPlayer.start();
                        photoIndex = 1;
                        break;
                    }
                    case 1: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_chengse);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_chengse);
                        mediaPlayer.start();
                        photoIndex = 2;
                        break;
                    }
                    case 2: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_huangse);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_huangse);
                        mediaPlayer.start();
                        photoIndex = 3;
                        break;
                    }
                    case 3: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_lvse);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_lvse);
                        mediaPlayer.start();
                        photoIndex = 4;
                        break;
                    }
                    case 4: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_lanse);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_lanse);
                        mediaPlayer.start();
                        photoIndex = 5;
                        break;
                    }
                    case 5: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_zise);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_zise);
                        mediaPlayer.start();
                        photoIndex = 6;
                        break;
                    }
                    case 6: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_fense);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_fense);
                        mediaPlayer.start();
                        photoIndex = 7;
                        break;
                    }
                    case 7: {//
                        yanse.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_heise);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_heise);
                        mediaPlayer.start();
                        photoIndex = 0;
                        break;
                    }


                }
                handler.postDelayed(runnable, 2000);
            }
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yanse);
        zuo=(Button)findViewById(R.id.zuo);
        you=(Button)findViewById(R.id.you);
        ch1=(Button)findViewById(R.id.ch1);
        eh1=(Button)findViewById(R.id.eh1);
        auto=(Button)findViewById(R.id.autoplay);
        zhuye=(Button)findViewById(R.id.zhuye);
        renshi=(TextView)findViewById(R.id.renshi);
        yanse=(ImageView)findViewById(R.id.yanse) ;
        zuo.setOnClickListener(this);
        you.setOnClickListener(this);
        ch1.setOnClickListener(this);
        eh1.setOnClickListener(this);
        zhuye.setOnClickListener(this);

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aflag=!aflag;
                if(aflag) {
                    auto.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.autuo_2));
                    handler.post(runnable);
                }
                else if(!aflag)
                {
                    auto.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.auto_1));
                    handler.removeCallbacks(runnable);}
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zuo:
                if (photoIndex == 0) {
                    photoIndex = maxIndex;
                } else {
                    photoIndex = photoIndex - 1;
                }
                Toast.makeText(this, "上一张", Toast.LENGTH_SHORT).show();
                break;
            case R.id.you:
                if (photoIndex == maxIndex) {
                    photoIndex = 0;
                } else {
                    photoIndex = photoIndex + 1;
                }
                Toast.makeText(this, "下一张", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch1:
                if(photoIndex == 0){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                    mediaPlayer.start();
                }
                if(photoIndex == 1){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                    mediaPlayer.start();
                }
                if(photoIndex == 2){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                    mediaPlayer.start();
                }
                if(photoIndex == 3){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                    mediaPlayer.start();
                }
                if(photoIndex == 4){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                    mediaPlayer.start();
                }
                if(photoIndex == 5){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                    mediaPlayer.start();
                }
                if(photoIndex == 6){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                    mediaPlayer.start();
                }
                if(photoIndex == 7){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                    mediaPlayer.start();
                }

                Toast.makeText(this, "中文播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.eh1:
                if(photoIndex == 0){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_hongse);
                    mediaPlayer.start();
                }
                if(photoIndex == 1){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_chengse);
                    mediaPlayer.start();
                }
                if(photoIndex == 2){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_huangse);
                    mediaPlayer.start();
                }
                if(photoIndex == 3){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_lvse);
                    mediaPlayer.start();
                }
                if(photoIndex == 4){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_lanse);
                    mediaPlayer.start();
                }
                if(photoIndex == 5){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_zise);
                    mediaPlayer.start();
                }
                if(photoIndex == 6){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_fense);
                    mediaPlayer.start();
                }
                if(photoIndex == 7){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_heise);
                    mediaPlayer.start();
                }

                Toast.makeText(this, "英文播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhuye:
//                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent(this,MainActivity.class);
//                startActivity(intent1);
//                break;
                finish();
        }
        yanse.setImageResource(photos[photoIndex]);

    }
    protected  void onPause(){
        super.onPause();

        System.out.println("调用onpause");
        handler.removeCallbacks(runnable);
    }
}
