package com.liliwei.knowpic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class jtestch extends AppCompatActivity implements View.OnClickListener {
    private ImageView test1;
    private ImageView test2;
    private ImageView test3;
    private ImageView test4;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private TextView text;
    private int mainflag = 0;
    private int tflag = 0;
    private int count1 = 0;
    public boolean endsa = false;
    public boolean endsb = false;
    public boolean endsc = false;
    public boolean endsd = false;

    private MediaPlayer mediaPlayer;
    private int[] photos = {R.drawable.changjinglu, R.drawable.daxiang, R.drawable.daxiongmao,
            R.drawable.huli, R.drawable.tuzi, R.drawable.wugui,
            R.drawable.caomei, R.drawable.mangguo, R.drawable.mihoutao, R.drawable.putao, R.drawable.xiangjiao, R.drawable.xigua,
            R.drawable.boluo, R.drawable.mugua, R.drawable.pingguo, R.drawable.shiliu, R.drawable.yingtao,
            R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
            R.drawable.eight, R.drawable.nine, R.drawable.ten,
            R.drawable.feiji, R.drawable.huoche, R.drawable.jiaoche, R.drawable.jipuche, R.drawable.jiuhuche, R.drawable.motuoche, R.drawable.xiaofangche,
            R.drawable.hongse, R.drawable.chengse, R.drawable.huangse, R.drawable.lvse, R.drawable.lanse, R.drawable.zise, R.drawable.heise, R.drawable.fense,
            R.drawable.zhengfangxing, R.drawable.yuanxing, R.drawable.sanjiaoxing, R.drawable.wujiaoxingxing, R.drawable.changfangxing};

    private int[] array = new int[]{1, 2, 3, 4};
    public int[] brray = new int[]{0, 1, 2, 3};
    public int[] crray = new int[]{5, 6, 7, 8};
    public int[] drray = new int[]{4, 7, 8, 9};
    public int[] erray = new int[]{4, 6, 8, 9};
    private int count = 0;
    public int rflag = 0;
    private int min = 0;
    private int max2 = 4;
    private int max = 46;
    Random random = new Random();
    Random random1 = new Random();
    Random random2 = new Random();
    Random random3 = new Random();
    Random random4 = new Random();
    Random random5 = new Random();

    private int array1 = random1.nextInt(max2) % (max2 - min + 1) - min;
    public int brray1 = random2.nextInt(max2) % (max2 - min + 1) - min;
    public int crray1 = random3.nextInt(max2) % (max2 - min + 1) - min;
    public int drray1 = random4.nextInt(max2) % (max2 - min + 1) - min;
    public int erray1 = random5.nextInt(max2) % (max2 - min + 1) - min;
    public int array2 = array1;
    public int brray2 = brray1;
    public int crray2 = crray1;
    public int drray2 = drray1;
    public int erray2 = erray1;
    public int erray3 = erray1;
    public int array3 = array1;
    public int brray3 = brray1;
    public int crray3 = crray1;
    public int drray3 = drray1;
    public int array4 = array1;
    public int brray4 = brray1;
    public int crray4 = crray1;
    public int drray4 = drray1;
    public int erray4 = erray1;
    public int array5 = array1;
    public int brray5 = brray1;
    public int crray5 = crray1;
    public int drray5 = drray1;
    public int erray5 = erray1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.testch);

        getArray();
        getBrray();
        getCrray();
        getDrray();
        getErray();
        rflag = 1;
        test1 = (ImageView) findViewById(R.id.test1);
        test2 = (ImageView) findViewById(R.id.test2);
        test3 = (ImageView) findViewById(R.id.test3);
        test4 = (ImageView) findViewById(R.id.test4);
        bt1 = (Button) findViewById(R.id.btn1);
        bt2 = (Button) findViewById(R.id.btn2);
        bt3 = (Button) findViewById(R.id.btn3);
        bt4 = (Button) findViewById(R.id.btn4);
        bt5 = (Button) findViewById(R.id.back);
        bt6 = (Button) findViewById(R.id.again);
        text=(TextView)findViewById(R.id.jieguo) ;
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
//        text.setText("第1/5题下面哪幅图是：");
        test1.setImageResource(photos[array[0]]);
        test2.setImageResource(photos[array[1]]);
        test3.setImageResource(photos[array[2]]);
        test4.setImageResource(photos[array[3]]);
        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tip);
        mediaPlayer.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
        switch (array[array1]) {
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                mediaPlayer.start();
                break;
            case 24:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                mediaPlayer.start();
                break;
            case 25:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                mediaPlayer.start();
                break;
            case 26:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                mediaPlayer.start();
                break;
            case 27:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                mediaPlayer.start();
                break;
            case 28:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                mediaPlayer.start();
                break;
            case 29:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                mediaPlayer.start();
                break;
            case 30:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                mediaPlayer.start();
                break;
            case 31:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                mediaPlayer.start();
                break;
            case 32:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                mediaPlayer.start();
                break;
            case 33:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                mediaPlayer.start();
                break;
            case 34:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                mediaPlayer.start();
                break;
            case 35:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                mediaPlayer.start();
                break;
            case 36:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                mediaPlayer.start();
                break;
            case 37:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                mediaPlayer.start();
                break;
            case 38:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                mediaPlayer.start();
                break;
            case 39:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                mediaPlayer.start();
                break;
            case 40:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                mediaPlayer.start();
                break;
            case 41:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                mediaPlayer.start();
                break;
            case 42:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                mediaPlayer.start();
                break;
            case 43:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                mediaPlayer.start();
                break;
            case 44:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                mediaPlayer.start();
                break;
            case 45:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                mediaPlayer.start();
                break;
            case 46:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                mediaPlayer.start();
                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (array[0] == array[array2] && mainflag == 0) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (array[0] != array[array2] && mainflag == 0) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (brray[0] == brray[brray2] && mainflag == 1) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (brray[0] != brray[brray2] && mainflag == 1) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (crray[0] == crray[crray2] && mainflag == 2) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (crray[0] != crray[crray2] && mainflag == 2) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (drray[0] == drray[drray2] && mainflag == 3) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (drray[0] != drray[drray2] && mainflag == 3) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (erray[0] == erray[erray2] && mainflag == 4) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (erray[0] != erray[erray2] && mainflag == 4) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (mainflag <= 4) {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                    }
                }
                endsd = true;
                if (mainflag == 0 && endsd) {
                    tbsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 1 && endsd) {
                    tcsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 2 && endsd) {
                    tdsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 3 && endsd) {
                    tesk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 4 && endsd) {
                    text.setText("你的得分：" + tflag * 20 + "分！");
                    switch (tflag) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.zerograde);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.twograde);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.threegrade);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fourgrade);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fivegrade);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.sixgrade);
                            mediaPlayer.start();
                            break;
                    }
                    mainflag++;
                    break;
                }
            case R.id.btn2:
                if (array[1] == array[array3] && mainflag == 0) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (array[1] != array[array3] && mainflag == 0) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (brray[1] == brray[brray3] && mainflag == 1) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (brray[1] != brray[brray3] && mainflag == 1) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (crray[1] == crray[crray3] && mainflag == 2) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (crray[1] != crray[crray3] && mainflag == 2) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (drray[1] == drray[drray3] && mainflag == 3) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (drray[1] != drray[drray3] && mainflag == 3) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (erray[1] == erray[erray3] && mainflag == 4) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (erray[1] != erray[erray3] && mainflag == 4) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (mainflag <= 4) {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                    }
                }
                endsd = true;
                if (mainflag == 0 && endsd) {
                    tbsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 1 && endsd) {
                    tcsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 2 && endsd) {
                    tdsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 3 && endsd) {
                    tesk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 4 && endsd) {
                    text.setText("你的得分：" + tflag * 20 + "分！");
                    switch (tflag) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.zerograde);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.twograde);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.threegrade);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fourgrade);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fivegrade);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.sixgrade);
                            mediaPlayer.start();
                            break;
                    }
                    mainflag++;
                    break;
                }


            case R.id.btn3:
                if (array[2] == array[array4] && mainflag == 0) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (array[2] != array[array4] && mainflag == 0) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (brray[2] == brray[brray4] && mainflag == 1) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (brray[2] != brray[brray4] && mainflag == 1) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (crray[2] == crray[crray4] && mainflag == 2) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();

                }
                if (crray[2] != crray[crray4] && mainflag == 2) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (drray[2] == drray[drray4] && mainflag == 3) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (drray[2] != drray[drray4] && mainflag == 3) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (erray[2] == erray[erray4] && mainflag == 4) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (erray[2] != erray[erray4] && mainflag == 4) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (mainflag <= 4) {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                    }
                }
                endsc = true;
                if (mainflag == 0 && endsc) {
                    tbsk();
                    mainflag++;
                    endsc = false;
                    break;
                }
                if (mainflag == 1 && endsc) {
                    tcsk();
                    mainflag++;
                    endsc = false;
                    break;
                }
                if (mainflag == 2 && endsc) {
                    tdsk();
                    mainflag++;
                    endsc = false;
                    break;
                }
                if (mainflag == 3 && endsc) {
                    tesk();
                    mainflag++;
                    endsc = false;
                    break;
                }
                if (mainflag == 4 && endsc) {
                    text.setText("你的得分：" + tflag * 20 + "分！");
                    switch (tflag) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.zerograde);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.twograde);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.threegrade);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fourgrade);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fivegrade);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.sixgrade);
                            mediaPlayer.start();
                            break;
                    }
                    mainflag++;
                    break;
                }

            case R.id.btn4:
                if (array[3] == array[array5] && mainflag == 0) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (array[3] != array[array5] && mainflag == 0) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (brray[3] == brray[brray5] && mainflag == 1) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (brray[3] != brray[brray5] && mainflag == 1) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (crray[3] == crray[crray5] && mainflag == 2) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (crray[3] != crray[crray5] && mainflag == 2) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (drray[3] == drray[drray5] && mainflag == 3) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (drray[3] != drray[drray5] && mainflag == 3) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (erray[3] == erray[erray5] && mainflag == 4) {
                    tflag++;
                    mediaPlayer = MediaPlayer.create(this, R.raw.truer);
                    mediaPlayer.start();
                }
                if (erray[3] != erray[erray5] && mainflag == 4) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.falser);
                    mediaPlayer.start();
                }
                if (mainflag < 4) {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                    }
                }
                if (mainflag == 4) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                    }
                }
                endsd = true;
                if (mainflag == 0 && endsd) {
                    tbsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 1 && endsd) {
                    tcsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 2 && endsd) {
                    tdsk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 3 && endsd) {
                    tesk();
                    mainflag++;
                    endsd = false;
                    break;
                }
                if (mainflag == 4 && endsd) {
                    text.setText("你的得分：" + tflag * 20 + "分！");
                    switch (tflag) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.zerograde);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.twograde);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.threegrade);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fourgrade);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.fivegrade);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.sixgrade);
                            mediaPlayer.start();
                            break;
                    }
                    mainflag++;
                    break;
                }
            case R.id.back:
                finish();
                break;
            case R.id.again:
                if (rflag == 1) {
                    switch (array[array1]) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                            mediaPlayer.start();
                            break;
                        case 6:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                            mediaPlayer.start();
                            break;
                        case 7:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                            mediaPlayer.start();
                            break;
                        case 8:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                            mediaPlayer.start();
                            break;
                        case 9:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                            mediaPlayer.start();
                            break;
                        case 10:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                            mediaPlayer.start();
                            break;
                        case 11:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                            mediaPlayer.start();
                            break;
                        case 12:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                            mediaPlayer.start();
                            break;
                        case 13:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                            mediaPlayer.start();
                            break;
                        case 14:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                            mediaPlayer.start();
                            break;
                        case 15:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                            mediaPlayer.start();
                            break;
                        case 16:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                            mediaPlayer.start();
                            break;
                        case 17:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                            mediaPlayer.start();
                            break;
                        case 18:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                            mediaPlayer.start();
                            break;
                        case 19:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                            mediaPlayer.start();
                            break;
                        case 20:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                            mediaPlayer.start();
                            break;
                        case 21:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                            mediaPlayer.start();
                            break;
                        case 22:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                            mediaPlayer.start();
                            break;
                        case 23:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                            mediaPlayer.start();
                            break;
                        case 24:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                            mediaPlayer.start();
                            break;
                        case 25:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                            mediaPlayer.start();
                            break;
                        case 26:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                            mediaPlayer.start();
                            break;
                        case 27:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                            mediaPlayer.start();
                            break;
                        case 28:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                            mediaPlayer.start();
                            break;
                        case 29:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                            mediaPlayer.start();
                            break;
                        case 30:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                            mediaPlayer.start();
                            break;
                        case 31:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                            mediaPlayer.start();
                            break;
                        case 32:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                            mediaPlayer.start();
                            break;
                        case 33:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                            mediaPlayer.start();
                            break;
                        case 34:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                            mediaPlayer.start();
                            break;
                        case 35:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                            mediaPlayer.start();
                            break;
                        case 36:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                            mediaPlayer.start();
                            break;
                        case 37:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                            mediaPlayer.start();
                            break;
                        case 38:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                            mediaPlayer.start();
                            break;
                        case 39:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                            mediaPlayer.start();
                            break;
                        case 40:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                            mediaPlayer.start();
                            break;
                        case 41:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                            mediaPlayer.start();
                            break;
                        case 42:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                            mediaPlayer.start();
                            break;
                        case 43:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                            mediaPlayer.start();
                            break;
                        case 44:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                            mediaPlayer.start();
                            break;
                        case 45:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                            mediaPlayer.start();
                            break;
                        case 46:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                            mediaPlayer.start();
                            break;
                    }
                }
                if (rflag == 2) {
                    switch (brray[brray1]) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                            mediaPlayer.start();
                            break;
                        case 6:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                            mediaPlayer.start();
                            break;
                        case 7:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                            mediaPlayer.start();
                            break;
                        case 8:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                            mediaPlayer.start();
                            break;
                        case 9:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                            mediaPlayer.start();
                            break;
                        case 10:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                            mediaPlayer.start();
                            break;
                        case 11:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                            mediaPlayer.start();
                            break;
                        case 12:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                            mediaPlayer.start();
                            break;
                        case 13:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                            mediaPlayer.start();
                            break;
                        case 14:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                            mediaPlayer.start();
                            break;
                        case 15:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                            mediaPlayer.start();
                            break;
                        case 16:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                            mediaPlayer.start();
                            break;
                        case 17:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                            mediaPlayer.start();
                            break;
                        case 18:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                            mediaPlayer.start();
                            break;
                        case 19:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                            mediaPlayer.start();
                            break;
                        case 20:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                            mediaPlayer.start();
                            break;
                        case 21:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                            mediaPlayer.start();
                            break;
                        case 22:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                            mediaPlayer.start();
                            break;
                        case 23:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                            mediaPlayer.start();
                            break;
                        case 24:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                            mediaPlayer.start();
                            break;
                        case 25:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                            mediaPlayer.start();
                            break;
                        case 26:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                            mediaPlayer.start();
                            break;
                        case 27:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                            mediaPlayer.start();
                            break;
                        case 28:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                            mediaPlayer.start();
                            break;
                        case 29:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                            mediaPlayer.start();
                            break;
                        case 30:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                            mediaPlayer.start();
                            break;
                        case 31:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                            mediaPlayer.start();
                            break;
                        case 32:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                            mediaPlayer.start();
                            break;
                        case 33:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                            mediaPlayer.start();
                            break;
                        case 34:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                            mediaPlayer.start();
                            break;
                        case 35:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                            mediaPlayer.start();
                            break;
                        case 36:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                            mediaPlayer.start();
                            break;
                        case 37:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                            mediaPlayer.start();
                            break;
                        case 38:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                            mediaPlayer.start();
                            break;
                        case 39:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                            mediaPlayer.start();
                            break;
                        case 40:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                            mediaPlayer.start();
                            break;
                        case 41:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                            mediaPlayer.start();
                            break;
                        case 42:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                            mediaPlayer.start();
                            break;
                        case 43:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                            mediaPlayer.start();
                            break;
                        case 44:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                            mediaPlayer.start();
                            break;
                        case 45:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                            mediaPlayer.start();
                            break;
                        case 46:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                            mediaPlayer.start();
                            break;
                    }
                }
                if (rflag == 3) {
                    switch (crray[crray1]) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                            mediaPlayer.start();
                            break;
                        case 6:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                            mediaPlayer.start();
                            break;
                        case 7:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                            mediaPlayer.start();
                            break;
                        case 8:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                            mediaPlayer.start();
                            break;
                        case 9:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                            mediaPlayer.start();
                            break;
                        case 10:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                            mediaPlayer.start();
                            break;
                        case 11:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                            mediaPlayer.start();
                            break;
                        case 12:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                            mediaPlayer.start();
                            break;
                        case 13:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                            mediaPlayer.start();
                            break;
                        case 14:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                            mediaPlayer.start();
                            break;
                        case 15:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                            mediaPlayer.start();
                            break;
                        case 16:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                            mediaPlayer.start();
                            break;
                        case 17:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                            mediaPlayer.start();
                            break;
                        case 18:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                            mediaPlayer.start();
                            break;
                        case 19:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                            mediaPlayer.start();
                            break;
                        case 20:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                            mediaPlayer.start();
                            break;
                        case 21:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                            mediaPlayer.start();
                            break;
                        case 22:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                            mediaPlayer.start();
                            break;
                        case 23:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                            mediaPlayer.start();
                            break;
                        case 24:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                            mediaPlayer.start();
                            break;
                        case 25:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                            mediaPlayer.start();
                            break;
                        case 26:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                            mediaPlayer.start();
                            break;
                        case 27:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                            mediaPlayer.start();
                            break;
                        case 28:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                            mediaPlayer.start();
                            break;
                        case 29:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                            mediaPlayer.start();
                            break;
                        case 30:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                            mediaPlayer.start();
                            break;
                        case 31:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                            mediaPlayer.start();
                            break;
                        case 32:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                            mediaPlayer.start();
                            break;
                        case 33:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                            mediaPlayer.start();
                            break;
                        case 34:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                            mediaPlayer.start();
                            break;
                        case 35:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                            mediaPlayer.start();
                            break;
                        case 36:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                            mediaPlayer.start();
                            break;
                        case 37:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                            mediaPlayer.start();
                            break;
                        case 38:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                            mediaPlayer.start();
                            break;
                        case 39:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                            mediaPlayer.start();
                            break;
                        case 40:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                            mediaPlayer.start();
                            break;
                        case 41:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                            mediaPlayer.start();
                            break;
                        case 42:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                            mediaPlayer.start();
                            break;
                        case 43:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                            mediaPlayer.start();
                            break;
                        case 44:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                            mediaPlayer.start();
                            break;
                        case 45:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                            mediaPlayer.start();
                            break;
                        case 46:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                            mediaPlayer.start();
                            break;
                    }
                }
                if (rflag == 4) {
                    switch (drray[drray1]) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                            mediaPlayer.start();
                            break;
                        case 6:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                            mediaPlayer.start();
                            break;
                        case 7:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                            mediaPlayer.start();
                            break;
                        case 8:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                            mediaPlayer.start();
                            break;
                        case 9:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                            mediaPlayer.start();
                            break;
                        case 10:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                            mediaPlayer.start();
                            break;
                        case 11:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                            mediaPlayer.start();
                            break;
                        case 12:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                            mediaPlayer.start();
                            break;
                        case 13:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                            mediaPlayer.start();
                            break;
                        case 14:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                            mediaPlayer.start();
                            break;
                        case 15:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                            mediaPlayer.start();
                            break;
                        case 16:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                            mediaPlayer.start();
                            break;
                        case 17:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                            mediaPlayer.start();
                            break;
                        case 18:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                            mediaPlayer.start();
                            break;
                        case 19:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                            mediaPlayer.start();
                            break;
                        case 20:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                            mediaPlayer.start();
                            break;
                        case 21:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                            mediaPlayer.start();
                            break;
                        case 22:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                            mediaPlayer.start();
                            break;
                        case 23:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                            mediaPlayer.start();
                            break;
                        case 24:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                            mediaPlayer.start();
                            break;
                        case 25:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                            mediaPlayer.start();
                            break;
                        case 26:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                            mediaPlayer.start();
                            break;
                        case 27:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                            mediaPlayer.start();
                            break;
                        case 28:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                            mediaPlayer.start();
                            break;
                        case 29:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                            mediaPlayer.start();
                            break;
                        case 30:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                            mediaPlayer.start();
                            break;
                        case 31:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                            mediaPlayer.start();
                            break;
                        case 32:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                            mediaPlayer.start();
                            break;
                        case 33:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                            mediaPlayer.start();
                            break;
                        case 34:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                            mediaPlayer.start();
                            break;
                        case 35:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                            mediaPlayer.start();
                            break;
                        case 36:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                            mediaPlayer.start();
                            break;
                        case 37:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                            mediaPlayer.start();
                            break;
                        case 38:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                            mediaPlayer.start();
                            break;
                        case 39:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                            mediaPlayer.start();
                            break;
                        case 40:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                            mediaPlayer.start();
                            break;
                        case 41:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                            mediaPlayer.start();
                            break;
                        case 42:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                            mediaPlayer.start();
                            break;
                        case 43:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                            mediaPlayer.start();
                            break;
                        case 44:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                            mediaPlayer.start();
                            break;
                        case 45:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                            mediaPlayer.start();
                            break;
                        case 46:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                            mediaPlayer.start();
                            break;
                    }
                }
                if (rflag == 5) {
                    switch (erray[erray1]) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                            mediaPlayer.start();
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                            mediaPlayer.start();
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                            mediaPlayer.start();
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                            mediaPlayer.start();
                            break;
                        case 4:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                            mediaPlayer.start();
                            break;
                        case 5:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                            mediaPlayer.start();
                            break;
                        case 6:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                            mediaPlayer.start();
                            break;
                        case 7:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                            mediaPlayer.start();
                            break;
                        case 8:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                            mediaPlayer.start();
                            break;
                        case 9:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                            mediaPlayer.start();
                            break;
                        case 10:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                            mediaPlayer.start();
                            break;
                        case 11:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                            mediaPlayer.start();
                            break;
                        case 12:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                            mediaPlayer.start();
                            break;
                        case 13:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                            mediaPlayer.start();
                            break;
                        case 14:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                            mediaPlayer.start();
                            break;
                        case 15:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                            mediaPlayer.start();
                            break;
                        case 16:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                            mediaPlayer.start();
                            break;
                        case 17:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                            mediaPlayer.start();
                            break;
                        case 18:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                            mediaPlayer.start();
                            break;
                        case 19:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                            mediaPlayer.start();
                            break;
                        case 20:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                            mediaPlayer.start();
                            break;
                        case 21:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                            mediaPlayer.start();
                            break;
                        case 22:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                            mediaPlayer.start();
                            break;
                        case 23:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                            mediaPlayer.start();
                            break;
                        case 24:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                            mediaPlayer.start();
                            break;
                        case 25:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                            mediaPlayer.start();
                            break;
                        case 26:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                            mediaPlayer.start();
                            break;
                        case 27:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                            mediaPlayer.start();
                            break;
                        case 28:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                            mediaPlayer.start();
                            break;
                        case 29:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                            mediaPlayer.start();
                            break;
                        case 30:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                            mediaPlayer.start();
                            break;
                        case 31:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                            mediaPlayer.start();
                            break;
                        case 32:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                            mediaPlayer.start();
                            break;
                        case 33:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                            mediaPlayer.start();
                            break;
                        case 34:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                            mediaPlayer.start();
                            break;
                        case 35:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                            mediaPlayer.start();
                            break;
                        case 36:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                            mediaPlayer.start();
                            break;
                        case 37:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                            mediaPlayer.start();
                            break;
                        case 38:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                            mediaPlayer.start();
                            break;
                        case 39:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                            mediaPlayer.start();
                            break;
                        case 40:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                            mediaPlayer.start();
                            break;
                        case 41:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                            mediaPlayer.start();
                            break;
                        case 42:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                            mediaPlayer.start();
                            break;
                        case 43:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                            mediaPlayer.start();
                            break;
                        case 44:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                            mediaPlayer.start();
                            break;
                        case 45:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                            mediaPlayer.start();
                            break;
                        case 46:
                            mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                            mediaPlayer.start();
                            break;
                    }
                }
        }
    }
    public void getArray () {
        count = 0;
        while (count < array.length) {
            boolean flag = true;
            int r = random.nextInt(max) % (max - min + 1) + min;
            for (int i = 0; i < array.length; i++) {
                if (r == array[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                array[count] = r;
                count++;
            }
        }
    }
    public void getBrray () {
        count = 0;
        while (count < brray.length) {
            boolean flag1 = true;
            int r = random.nextInt(max) % (max - min + 1) + min;
            for (int i = 0; i < brray.length; i++) {
                if (r == brray[i]) {
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {
                brray[count] = r;
                count++;
            }
        }
    }
    public void getCrray () {
        count = 0;
        while (count < crray.length) {
            boolean flag2 = true;
            int r = random.nextInt(max) % (max - min + 1) + min;
            for (int i = 0; i < crray.length; i++) {
                if (r == crray[i]) {
                    flag2 = false;
                    break;
                }
            }
            if (flag2) {
                crray[count] = r;
                count++;
            }
        }
    }
    public void getDrray () {
        count = 0;
        while (count < drray.length) {
            boolean flag3 = true;
            int r = random.nextInt(max) % (max - min + 1) + min;
            for (int i = 0; i < drray.length; i++) {
                if (r == drray[i]) {
                    flag3 = false;
                    break;
                }
            }
            if (flag3) {
                drray[count] = r;
                count++;
            }
        }
    }
    public void getErray () {
        count = 0;
        while (count < erray.length) {
            boolean flag4 = true;
            int r = random.nextInt(max) % (max - min + 1) + min;
            for (int i = 0; i < erray.length; i++) {
                if (r == erray[i]) {
                    flag4 = false;
                    break;
                }
            }
            if (flag4) {
                erray[count] = r;
                count++;
            }
        }
    }
    public void tbsk(){
        try {
            Thread.sleep(500);
        } catch (Exception e){
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tip);
        mediaPlayer.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e){
        }
        switch (brray[brray1]){
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                mediaPlayer.start();
                break;
            case 24:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                mediaPlayer.start();
                break;
            case 25:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                mediaPlayer.start();
                break;
            case 26:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                mediaPlayer.start();
                break;
            case 27:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                mediaPlayer.start();
                break;
            case 28:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                mediaPlayer.start();
                break;
            case 29:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                mediaPlayer.start();
                break;
            case 30:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                mediaPlayer.start();
                break;
            case 31:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                mediaPlayer.start();
                break;
            case 32:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                mediaPlayer.start();
                break;
            case 33:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                mediaPlayer.start();
                break;
            case 34:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                mediaPlayer.start();
                break;
            case 35:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                mediaPlayer.start();
                break;
            case 36:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                mediaPlayer.start();
                break;
            case 37:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                mediaPlayer.start();
                break;
            case 38:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                mediaPlayer.start();
                break;
            case 39:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                mediaPlayer.start();
                break;
            case 40:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                mediaPlayer.start();
                break;
            case 41:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                mediaPlayer.start();
                break;
            case 42:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                mediaPlayer.start();
                break;
            case 43:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                mediaPlayer.start();
                break;
            case 44:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                mediaPlayer.start();
                break;
            case 45:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                mediaPlayer.start();
                break;
            case 46:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                mediaPlayer.start();
                break;
        }
        rflag=2;
//        text.setText("第2/5题下面哪幅图是：");
        test1.setImageResource(photos[brray[0]]);
        test2.setImageResource(photos[brray[1]]);
        test3.setImageResource(photos[brray[2]]);
        test4.setImageResource(photos[brray[3]]);
    }
    public void tcsk(){
        try {
            Thread.sleep(500);
        } catch (Exception e){
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tip);
        mediaPlayer.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e){
        }
        switch (crray[crray1]){
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                mediaPlayer.start();
                break;
            case 24:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                mediaPlayer.start();
                break;
            case 25:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                mediaPlayer.start();
                break;
            case 26:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                mediaPlayer.start();
                break;
            case 27:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                mediaPlayer.start();
                break;
            case 28:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                mediaPlayer.start();
                break;
            case 29:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                mediaPlayer.start();
                break;
            case 30:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                mediaPlayer.start();
                break;
            case 31:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                mediaPlayer.start();
                break;
            case 32:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                mediaPlayer.start();
                break;
            case 33:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                mediaPlayer.start();
                break;
            case 34:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                mediaPlayer.start();
                break;
            case 35:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                mediaPlayer.start();
                break;
            case 36:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                mediaPlayer.start();
                break;
            case 37:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                mediaPlayer.start();
                break;
            case 38:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                mediaPlayer.start();
                break;
            case 39:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                mediaPlayer.start();
                break;
            case 40:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                mediaPlayer.start();
                break;
            case 41:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                mediaPlayer.start();
                break;
            case 42:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                mediaPlayer.start();
                break;
            case 43:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                mediaPlayer.start();
                break;
            case 44:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                mediaPlayer.start();
                break;
            case 45:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                mediaPlayer.start();
                break;
            case 46:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                mediaPlayer.start();
                break;
        }
        rflag=3;
//        text.setText("第3/5题下面哪幅图是：");
        test1.setImageResource(photos[crray[0]]);
        test2.setImageResource(photos[crray[1]]);
        test3.setImageResource(photos[crray[2]]);
        test4.setImageResource(photos[crray[3]]);
    }
    public void tdsk(){
        try {
            Thread.sleep(500);
        } catch (Exception e){
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tip);
        mediaPlayer.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e){
        }
        switch (drray[drray1]){
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                mediaPlayer.start();
                break;
            case 24:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                mediaPlayer.start();
                break;
            case 25:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                mediaPlayer.start();
                break;
            case 26:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                mediaPlayer.start();
                break;
            case 27:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                mediaPlayer.start();
                break;
            case 28:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                mediaPlayer.start();
                break;
            case 29:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                mediaPlayer.start();
                break;
            case 30:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                mediaPlayer.start();
                break;
            case 31:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                mediaPlayer.start();
                break;
            case 32:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                mediaPlayer.start();
                break;
            case 33:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                mediaPlayer.start();
                break;
            case 34:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                mediaPlayer.start();
                break;
            case 35:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                mediaPlayer.start();
                break;
            case 36:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                mediaPlayer.start();
                break;
            case 37:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                mediaPlayer.start();
                break;
            case 38:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                mediaPlayer.start();
                break;
            case 39:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                mediaPlayer.start();
                break;
            case 40:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                mediaPlayer.start();
                break;
            case 41:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                mediaPlayer.start();
                break;
            case 42:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                mediaPlayer.start();
                break;
            case 43:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                mediaPlayer.start();
                break;
            case 44:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                mediaPlayer.start();
                break;
            case 45:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                mediaPlayer.start();
                break;
            case 46:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                mediaPlayer.start();
                break;
        }
        rflag=4;
//        text.setText("第4/5题下面哪幅图是：");
        test1.setImageResource(photos[drray[0]]);
        test2.setImageResource(photos[drray[1]]);
        test3.setImageResource(photos[drray[2]]);
        test4.setImageResource(photos[drray[3]]);
    }
    public void tesk(){
        try {
            Thread.sleep(500);
        } catch (Exception e){
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tip);
        mediaPlayer.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e){
        }
        switch (erray[erray1]){
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changjinglu);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiang);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_daxiongmao);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huli);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_tuzi);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wugui);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_caomei);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mangguo);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mihoutao);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_putao);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiangjiao);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xigua);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_boluo);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_mugua);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_pingguo);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shiliu);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yingtao);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yi);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_er);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_san);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_si);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wu);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_liu);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_qi);
                mediaPlayer.start();

                break;
            case 24:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_ba);
                mediaPlayer.start();
                break;
            case 25:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiu);
                mediaPlayer.start();
                break;
            case 26:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_shi);
                mediaPlayer.start();
                break;
            case 27:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_feiji);
                mediaPlayer.start();
                break;
            case 28:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huoche);
                mediaPlayer.start();
                break;
            case 29:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiaoche);
                mediaPlayer.start();
                break;
            case 30:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jipuche);
                mediaPlayer.start();
                break;
            case 31:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_jiuhuche);
                mediaPlayer.start();
                break;
            case 32:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_motuoche);
                mediaPlayer.start();
                break;
            case 33:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_xiaofangche);
                mediaPlayer.start();
                break;
            case 34:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_hongse);
                mediaPlayer.start();
                break;
            case 35:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_chengse);
                mediaPlayer.start();
                break;
            case 36:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_huangse);
                mediaPlayer.start();
                break;
            case 37:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lvse);
                mediaPlayer.start();
                break;
            case 38:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_lanse);
                mediaPlayer.start();
                break;
            case 39:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zise);
                mediaPlayer.start();
                break;
            case 40:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_heise);
                mediaPlayer.start();
                break;
            case 41:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_fense);
                mediaPlayer.start();
                break;
            case 42:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_zhengfangxing);
                mediaPlayer.start();
                break;
            case 43:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_yuanxing);
                mediaPlayer.start();
                break;
            case 44:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_sanjiaoxing);
                mediaPlayer.start();
                break;
            case 45:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_wujiaoxingxing);
                mediaPlayer.start();
                break;
            case 46:
                mediaPlayer = MediaPlayer.create(this, R.raw.ch_changfangxing);
                mediaPlayer.start();
                break;
        }
        rflag=5;
//        text.setText("第5/5题下面哪幅图是：");
        test1.setImageResource(photos[erray[0]]);
        test2.setImageResource(photos[erray[1]]);
        test3.setImageResource(photos[erray[2]]);
        test4.setImageResource(photos[erray[3]]);
    }
}
