package com.felhr.serialportexample;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by m on 27/05/17.
 */

public class LlamadaActivity extends AppCompatActivity {

    static String laVariable;// alguien ,  nadie , persona atenta
    static TextView elTexto;
    static MediaPlayer elSonido;
    ImageView laImagen;
    Button contestarBtn;
    static Context elContextico;




    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llamada_entrante);
        getSupportActionBar().hide();

        elSonido = MediaPlayer.create(this, R.raw.telephonering);
        elSonido.setLooping(true);//siempre se repite el sonido
        elSonido.start();

        elContextico = getApplicationContext();

        //Se contesta el teleofono con microswicth


        //if(MainActivity.yaContesto==true) pasaAHistorias();


        //Boton contestar
       /* contestarBtn = (Button) findViewById(R.id.contestar);
        contestarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LlamadaActivity.this, "Alguien contesta debug", Toast.LENGTH_SHORT).show();
                //laVariable = "alguien contesta";

                elSonido.stop();

                Intent intent = new Intent(getApplicationContext(), HistoriaActividad.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        */



    }


    @Override
    protected void onResume() {
        super.onResume();

        if(MainActivity.yaContesto == true){
            Toast.makeText(getApplicationContext(), "Ya contestaron", Toast.LENGTH_SHORT).show();
            pasaAHistorias();
        }
    }

    public static void pasaAHistorias(){
        Intent intent = new Intent(elContextico.getApplicationContext(), HistoriaActividad.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        elContextico.startActivity(intent);
        SystemClock.sleep(4000);

        elSonido.stop();

//        finish();
    }

}
