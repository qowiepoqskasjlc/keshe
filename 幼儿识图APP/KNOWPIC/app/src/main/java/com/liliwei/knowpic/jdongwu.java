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

public class jdongwu extends AppCompatActivity implements View.OnClickListener {
    private Button zuo;
    private Button you;
    private Button ch1;
    private Button eh1;
    private Button auto;
    private Button zhuye;
    private TextView renshi;
    private ImageView dongwu;
    private LinearLayout ground;
    private boolean aflag=false;
    private MediaPlayer mediaPlayer;

    private int[] photos = {R.drawable.changjinglu, R.drawable.daxiang, R.drawable.daxiongmao,
            R.drawable.huli, R.drawable.tuzi,R.drawable.wugui};

    private int photoIndex = 0;
    private int maxIndex = 5;
    static Handler handler =new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            {
                dongwu=(ImageView)findViewById(R.id.dongwu) ;
                switch (photoIndex) {
                    case 0: {//如果没有歌     长颈鹿
                        dongwu.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_changjinglu);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_changjinglu);
                        mediaPlayer.start();
                        photoIndex=1;
                        break;
                    }
                    case 1: {//如果没有歌    大象
                        dongwu.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_daxiang);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_daxiang);
                        mediaPlayer.start();
                        photoIndex=2;
                        break;
                    }
                    case 2: {//如果没有歌   大熊猫
                        dongwu.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_daxiongmao);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_daxiongmao);
                        mediaPlayer.start();
                        photoIndex=3;
                        break;
                    }
                    case 3: {//如果没有歌  狐狸
                        dongwu.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_huli);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_huli);
                        mediaPlayer.start();
                        photoIndex=4;
                        break;
                    }
                    case 4: {//如果没有歌  兔子
                        dongwu.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_tuzi);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_tuzi);
                        mediaPlayer.start();
                        photoIndex=5;
                        break;
                    }
                    case 5: {//如果没有歌   乌龟
                        dongwu.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_wugui);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_wugui);
                        mediaPlayer.start();
                        photoIndex=0;
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
        setContentView(R.layout.dongwu);
        zuo=(Button)findViewById(R.id.zuo);
        you=(Button)findViewById(R.id.you);
        ch1=(Button)findViewById(R.id.ch1);
        eh1=(Button)findViewById(R.id.eh1);
        auto=(Button)findViewById(R.id.autoplay);
        zhuye=(Button)findViewById(R.id.zhuye);
        renshi=(TextView)findViewById(R.id.renshi);
        dongwu=(ImageView)findViewById(R.id.dongwu) ;
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
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                    mediaPlayer.start();
                }
                if(photoIndex == 1){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                    mediaPlayer.start();
                }
                if(photoIndex == 2){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                    mediaPlayer.start();
                }
                if(photoIndex == 3){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                    mediaPlayer.start();
                }
                if(photoIndex == 4){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                    mediaPlayer.start();
                }
                if(photoIndex == 5){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                    mediaPlayer.start();
                }

                Toast.makeText(this, "中文播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.eh1:
                if(photoIndex == 0){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_changjinglu);
                    mediaPlayer.start();
                }
                if(photoIndex == 1){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_daxiang);
                    mediaPlayer.start();
                }
                if(photoIndex == 2){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_daxiongmao);
                    mediaPlayer.start();
                }
                if(photoIndex == 3){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_huli);
                    mediaPlayer.start();
                }
                if(photoIndex == 4){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_tuzi);
                    mediaPlayer.start();
                }
                if(photoIndex == 5){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_wugui);
                    mediaPlayer.start();
                }
                Toast.makeText(this, "英文播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhuye:
//                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent(this,MainActivity.class);
//                startActivity(intent1);
                finish();
        }
        dongwu.setImageResource(photos[photoIndex]);

    }

    protected  void onPause(){
        super.onPause();

        System.out.println("调用onpause");
        handler.removeCallbacks(runnable);
    }
}
