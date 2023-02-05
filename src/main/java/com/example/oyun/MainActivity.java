package com.example.oyun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView sure,puan;
    ImageView ıv1,ıv2,ıv3,ıv4,ıv5,ıv6,ıv7,ıv8,ıv9;
    ImageView[] foto=new  ImageView[9];
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sure=findViewById(R.id.txt_sure);
        puan =findViewById(R.id.txt_puan);
        ıv1=findViewById(R.id.imageView2);
        ıv2=findViewById(R.id.imageView3);
        ıv3=findViewById(R.id.imageView4);
        ıv4=findViewById(R.id.imageView5);
        ıv5=findViewById(R.id.imageView6);
        ıv6=findViewById(R.id.imageView8);
        ıv7=findViewById(R.id.imageView9);
        ıv8=findViewById(R.id.imageView10);
        ıv9=findViewById(R.id.imageView11);

        foto = new  ImageView[]{ıv1,ıv2,ıv3,ıv4,ıv5,ıv6,ıv7,ıv8,ıv9};

        CountDownTimer sayac =new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long l) {
                sure.setText("Kalan Süreniz : "+ l/1000);
            }

            @Override
            public void onFinish() {
                sure.setText("Süreniz bitti !");
            }
        };
        sayac.start();
        fotoGizle();
    }

    private void fotoGizle() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (ImageView iv: foto)
                    iv.setVisibility(View.INVISIBLE);
                Random rst=new Random();
                int index = rst.nextInt(9);
                foto[index].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);
            }
        });

    }
}