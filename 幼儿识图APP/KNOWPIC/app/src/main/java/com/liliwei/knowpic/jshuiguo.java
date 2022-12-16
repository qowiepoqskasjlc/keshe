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

public class jshuiguo extends AppCompatActivity implements View.OnClickListener {
    private Button zuo;
    private Button you;
    private Button ch1;
    private Button eh1;
    private Button auto;
    private Button zhuye;
    private TextView renshi;
    private ImageView shuiguo;
    private LinearLayout ground;
    private boolean aflag=false;
    private MediaPlayer mediaPlayer;
    private int[] photos = {R.drawable.boluo, R.drawable.caomei, R.drawable.mangguo,
            R.drawable.mihoutao, R.drawable.mugua,R.drawable.pingguo,R.drawable.putao,
            R.drawable.shiliu,R.drawable.xiangjiao,R.drawable.xigua,R.drawable.yingtao};

    private int photoIndex = 0;
    private int maxIndex = 10;
    static Handler handler =new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            {
                shuiguo = (ImageView) findViewById(R.id.shuiguo);
                switch (photoIndex) {
                    case 0: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_boluo);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_boluo);
                        mediaPlayer.start();
                        photoIndex = 1;
                        break;
                    }
                    case 1: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_caomei);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_caomei);
                        mediaPlayer.start();
                        photoIndex = 2;
                        break;
                    }
                    case 2: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_mangguo);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_mangguo);
                        mediaPlayer.start();
                        photoIndex = 3;
                        break;
                    }
                    case 3: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_mihoutao);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_mihoutao);
                        mediaPlayer.start();
                        photoIndex = 4;
                        break;
                    }
                    case 4: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_mugua);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_mugua);
                        mediaPlayer.start();
                        photoIndex = 5;
                        break;
                    }
                    case 5: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_pingguo);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_pingguo);
                        mediaPlayer.start();
                        photoIndex = 6;
                        break;
                    }
                    case 6: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_putao);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_putao);
                        mediaPlayer.start();
                        photoIndex = 7;
                        break;
                    }
                    case 7: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_shiliu);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_shiliu);
                        mediaPlayer.start();
                        photoIndex = 8;
                        break;
                    }
                    case 8: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_xiangjiao);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_xiangjiao);
                        mediaPlayer.start();
                        photoIndex = 9;
                        break;
                    }
                    case 9: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_xigua);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_xigua);
                        mediaPlayer.start();
                        photoIndex = 10;
                        break;
                    }
                    case 10: {//
                        shuiguo.setImageResource(photos[photoIndex]);
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ch_yingtao);
                        mediaPlayer.start();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.en_yingtao);
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
        setContentView(R.layout.shuiguo);
        zuo=(Button)findViewById(R.id.zuo);
        you=(Button)findViewById(R.id.you);
        ch1=(Button)findViewById(R.id.ch1);
        eh1=(Button)findViewById(R.id.eh1);
        auto=(Button)findViewById(R.id.autoplay);
        zhuye=(Button)findViewById(R.id.zhuye);
        renshi=(TextView)findViewById(R.id.renshi);
        shuiguo=(ImageView)findViewById(R.id.shuiguo) ;
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
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                    mediaPlayer.start();
                }
                if(photoIndex == 1){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                    mediaPlayer.start();
                }
                if(photoIndex == 2){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                    mediaPlayer.start();
                }
                if(photoIndex == 3){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                    mediaPlayer.start();
                }
                if(photoIndex == 4){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                    mediaPlayer.start();
                }
                if(photoIndex == 5){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                    mediaPlayer.start();
                }
                if(photoIndex == 6){//如果没有歌
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                    mediaPlayer.start();
                }
                if(photoIndex == 7){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                    mediaPlayer.start();
                }
                if(photoIndex == 8){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                    mediaPlayer.start();
                }
                if(photoIndex == 9){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                    mediaPlayer.start();
                }
                if(photoIndex == 10){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                    mediaPlayer.start();
                }

                Toast.makeText(this, "中文播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.eh1:
                if(photoIndex == 0){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_boluo);
                    mediaPlayer.start();
                }
                if(photoIndex == 1){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_caomei);
                    mediaPlayer.start();
                }
                if(photoIndex == 2){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_mangguo);
                    mediaPlayer.start();
                }
                if(photoIndex == 3){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_mihoutao);
                    mediaPlayer.start();
                }
                if(photoIndex == 4){//
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_mugua);
                    mediaPlayer.start();
                }
                if(photoIndex == 5){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_pingguo);
                    mediaPlayer.start();
                }
                if(photoIndex == 6){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_putao);
                    mediaPlayer.start();
                }
                if(photoIndex == 7){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_shiliu);
                    mediaPlayer.start();
                }
                if(photoIndex == 8){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_xiangjiao);
                    mediaPlayer.start();
                }
                if(photoIndex == 9){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_xigua);
                    mediaPlayer.start();
                }
                if(photoIndex == 10){
                    mediaPlayer = MediaPlayer.create(this, R.raw.en_yingtao);
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
        shuiguo.setImageResource(photos[photoIndex]);


    }
    protected  void onPause(){
        super.onPause();

        System.out.println("调用onpause");
        handler.removeCallbacks(runnable);
    }
}
