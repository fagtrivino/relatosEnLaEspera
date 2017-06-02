package com.felhr.serialportexample;

/**
 * Created by m on 26/05/17.
 */


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by m on 25/05/17.
 */

public class CuelgActivity extends AppCompatActivity {

    boolean colgado = true;
    static Context elContextico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuelga_layout);
        getSupportActionBar().hide();

        elContextico = getApplicationContext();
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
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("yapaso",true);
                        intent.putExtra("yacontesto",true);
                        //intent.putExtra("")
                        startActivity(intent);
                    }
                });
            }
        }).start();
       //SystemClock.sleep(10000);



    }

    public static void mataColgar(){

       /* Intent intent = new Intent(elContextico.getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                */

        Intent i = elContextico.getPackageManager()
                .getLaunchIntentForPackage( elContextico.getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        elContextico.startActivity(i);
        //SystemClock.sleep(4000);

       // elContextico.startActivity(intent);

        //elSonido.stop();

//        finish();
    }
}
