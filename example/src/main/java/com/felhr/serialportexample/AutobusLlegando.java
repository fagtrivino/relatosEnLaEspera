package com.felhr.serialportexample;

/**
 * Created by m on 26/05/17.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by m on 25/05/17.
 */

public class AutobusLlegando extends AppCompatActivity {

    TextView escritor,locutor;
    static Context elContextico;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autobus_llegando);

        elContextico = getApplicationContext();

        //TextViews
        escritor = (TextView) findViewById(R.id.escrito);
        locutor = (TextView) findViewById(R.id.locucion);

        escritor.setText("Escrito por "+getIntent().getStringExtra("autor"));
        locutor.setText("Locutor "+getIntent().getStringExtra("locutor"));

        getSupportActionBar().hide();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(),CuelgActivity.class));
                    }
                });
            }
        }).start();
        //SystemClock.sleep(4000);
        //startActivity(new Intent(getApplicationContext(),CuelgActivity.class));

    }

    public static void mataBusLlegando(){
        Intent intent = new Intent(elContextico.getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        elContextico.startActivity(intent);
        //elSonido.stop();

//        finish();
    }
}
