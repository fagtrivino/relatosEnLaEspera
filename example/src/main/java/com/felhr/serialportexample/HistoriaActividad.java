package com.felhr.serialportexample;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by m on 21/05/17.
 */

public class HistoriaActividad extends AppCompatActivity {

    Button oneMin,twoMins,tresMin,cuatroMin,cincoMin,seisMin,sieteMin,ochoMin,nueveMin,diezMin;
    Intent intent;

    private final static int MAX_VOLUME = 100;

    public int soundVolume = 100;
    public static Context elContextico;

    static String laVariable;// alguien ,  nadie , persona atenta
    static TextView elTexto;
    static MediaPlayer elSonido;
    ImageView laImagen;
    Button contestarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historias_layout);

        elSonido = MediaPlayer.create(this, R.raw.holasoyleo);
        elSonido.setLooping(false);

        elContextico = getApplicationContext();
        //seteando el volumen
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
        elSonido.setVolume(volume, volume);


        oneMin = (Button) findViewById(R.id.onemin);
        twoMins = (Button) findViewById(R.id.dosmin);
        tresMin = (Button) findViewById(R.id.tresmin);
        cuatroMin = (Button) findViewById(R.id.cuatromin);
        cincoMin = (Button) findViewById(R.id.cincomin);
        seisMin = (Button) findViewById(R.id.seismin);
        sieteMin = (Button) findViewById(R.id.sietemin);
        ochoMin  = (Button) findViewById(R.id.ochomin);
        nueveMin  = (Button) findViewById(R.id.nuevemins);
        diezMin = (Button) findViewById(R.id.diezmin);

        getSupportActionBar().hide();

        intent = new Intent(getApplicationContext(),EscuchaHistoriasActividad.class);
        elSonido.start();//audio cuanto tiempo vas a esperar

        oneMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","onemin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        twoMins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","twomins");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        tresMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","tresmin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        cuatroMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","cuatromin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        cincoMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","cincomin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        seisMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","seismin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        sieteMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","sietemin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        ochoMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","ochomin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        nueveMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","nuevemin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });

        diezMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mins","diezmin");
                MainActivity.yaEligio = true;
                startActivity(intent);
                elSonido.stop();//audio cuanto tiempo vas a esperar
                finish();
            }
        });



    }

    public static void mataHistorias(){
        Intent intent = new Intent(elContextico.getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        elContextico.startActivity(intent);
        elSonido.stop();

//        finish();
    }
}
