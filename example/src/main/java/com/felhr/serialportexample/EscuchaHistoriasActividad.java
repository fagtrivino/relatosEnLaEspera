package com.felhr.serialportexample;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.Random;

/**
 * Created by m on 26/05/17.
 */

public class EscuchaHistoriasActividad extends AppCompatActivity {

    ProgressBar barra;
    String minutos;
    static MediaPlayer elSonido1;
    static MediaPlayer elSonido2;
    static MediaPlayer elSonido3;
    static MediaPlayer elSonido4;
    static MediaPlayer elSonido5;
    static MediaPlayer elSonido6;
    static MediaPlayer elSonido7;
    static MediaPlayer elSonido8;
    static MediaPlayer elSonido9;
    static MediaPlayer elSonido10;
    static MediaPlayer elSonido11;
    static MediaPlayer elSonido12;
    static MediaPlayer elSonido13;
    static MediaPlayer elSonido14;
    static MediaPlayer elSonido15;
    static MediaPlayer elSonido16;
    static MediaPlayer elSonido17;
    static MediaPlayer elSonido18;
    static MediaPlayer elSonido19;
    static MediaPlayer elSonido20;

    static Context elContextico;

    private final static int MAX_VOLUME = 100;
    public int soundVolume = 65;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escucha_historias_layout);

        getSupportActionBar().hide();

        elContextico = getApplicationContext();

        //seteando el volumen
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));


        //Inicializando poemas

        //relatos 1 min
        elSonido1 = MediaPlayer.create(this, R.raw.enunminuto);
        elSonido11 = MediaPlayer.create(this, R.raw.dosminutos);
        elSonido12 = MediaPlayer.create(this, R.raw.esperandotuespera);
        elSonido13 = MediaPlayer.create(this, R.raw.algonuevo);
        elSonido14 = MediaPlayer.create(this, R.raw.porsorpresa);

        //relatos 2 min
        elSonido2 = MediaPlayer.create(this, R.raw.comonobailarsalsa);
        elSonido15 = MediaPlayer.create(this, R.raw.eltapicero);
        elSonido16 = MediaPlayer.create(this, R.raw.lamuerteyladoncella);
        elSonido17 = MediaPlayer.create(this, R.raw.sebuscapoeta);

        //relatos 3 min
        elSonido3 = MediaPlayer.create(this, R.raw.besoenlaparada);
        elSonido18 = MediaPlayer.create(this, R.raw.chofer);
        elSonido19 = MediaPlayer.create(this, R.raw.tardededomingo);

        //relatos 4 min
        elSonido4 = MediaPlayer.create(this, R.raw.elflautista);
        elSonido20 = MediaPlayer.create(this, R.raw.ocupacionparadesocupados);


        elSonido5 = MediaPlayer.create(this, R.raw.chocolateconchurros);
        elSonido6 = MediaPlayer.create(this, R.raw.chocolateconchurros);
        elSonido7 = MediaPlayer.create(this, R.raw.unfantasmaenzinga);
        elSonido8 = MediaPlayer.create(this, R.raw.bolsaparalacompra);
        elSonido9 = MediaPlayer.create(this, R.raw.bolsaparalacompra);
        elSonido10 = MediaPlayer.create(this, R.raw.undostres);

        elSonido1.setLooping(false);
        elSonido2.setLooping(false);
        elSonido3.setLooping(false);
        elSonido4.setLooping(false);
        elSonido5.setLooping(false);
        elSonido6.setLooping(false);
        elSonido7.setLooping(false);
        elSonido8.setLooping(false);
        elSonido9.setLooping(false);
        elSonido10.setLooping(false);
        elSonido11.setLooping(false);
        elSonido12.setLooping(false);
        elSonido13.setLooping(false);
        elSonido14.setLooping(false);
        elSonido15.setLooping(false);
        elSonido16.setLooping(false);
        elSonido17.setLooping(false);
        elSonido18.setLooping(false);
        elSonido19.setLooping(false);
        elSonido20.setLooping(false);


        elSonido1.setVolume(volume, volume);
        elSonido2.setVolume(volume, volume);
        elSonido3.setVolume(volume, volume);
        elSonido4.setVolume(volume, volume);
        elSonido5.setVolume(volume, volume);
        elSonido6.setVolume(volume, volume);
        elSonido7.setVolume(volume, volume);
        elSonido8.setVolume(volume, volume);
        elSonido9.setVolume(volume, volume);
        elSonido10.setVolume(volume, volume);
        elSonido11.setVolume(volume, volume);
        elSonido12.setVolume(volume, volume);
        elSonido13.setVolume(volume, volume);
        elSonido14.setVolume(volume, volume);
        elSonido15.setVolume(volume, volume);
        elSonido16.setVolume(volume, volume);
        elSonido17.setVolume(volume, volume);
        elSonido18.setVolume(volume, volume);
        elSonido19.setVolume(volume, volume);
        elSonido20.setVolume(volume, volume);


        barra = (ProgressBar) findViewById(R.id.progressBar);
        barra.setIndeterminate(true);//loop del cargando

        minutos = getIntent().getStringExtra("mins");
        switch (minutos){
            case "onemin":
                Toast.makeText(getApplicationContext(),"contando historia de un min",Toast.LENGTH_SHORT);
                //elSonido1.start();
                eligeHistoria1min(elSonido1,elSonido11,elSonido12,elSonido13,elSonido14);
                break;
            case "twomins":
                Toast.makeText(getApplicationContext(),"contando historias de dos mins",Toast.LENGTH_SHORT);
                //elSonido2.start();
                eligeHistoria2min(elSonido2,elSonido15,elSonido16,elSonido17);
                break;
            case "tresmin":
                Toast.makeText(getApplicationContext(),"contando historias de tes mins",Toast.LENGTH_SHORT);
                //elSonido3.start();
                eligeHistoria3min(elSonido3,elSonido18,elSonido19);
                break;
            case "cuatromin":
                Toast.makeText(getApplicationContext(),"contando historias de cuatro mins",Toast.LENGTH_SHORT);
                //elSonido4.start();
                eligeHistoria4min(elSonido4,elSonido20);
                break;
            case "cincomin":
                Toast.makeText(getApplicationContext(),"contando historias de cinco mins",Toast.LENGTH_SHORT);
                elSonido5.start();
                break;
            case "seismin":
                Toast.makeText(getApplicationContext(),"contando historias de seis mins",Toast.LENGTH_SHORT);
                elSonido6.start();
                break;
            case "sietemin":
                Toast.makeText(getApplicationContext(),"contando historias de siete mins",Toast.LENGTH_SHORT);
                elSonido7.start();
                break;
            case "ochomin":
                Toast.makeText(getApplicationContext(),"contando historias de ocho mins",Toast.LENGTH_SHORT);
                elSonido8.start();
                break;
            case "nuevemin":
                Toast.makeText(getApplicationContext(),"contando historias de nueve mins",Toast.LENGTH_SHORT);
                elSonido9.start();
                break;
            case "diezmin":
                Toast.makeText(getApplicationContext(),"contando historias de diez mins",Toast.LENGTH_SHORT);
                elSonido10.start();
                break;


        }

        //Cuando se acaba
        elSonido1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Bernardo Gomez");
                i.putExtra("locutor","Bernardo Gomez");
                startActivity(i);
                finish();
            }
        });
        elSonido2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Max Cooper");
                i.putExtra("locutor","Monica Montoro");
                startActivity(i);
                finish();
            }
        });
        elSonido3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Aurora Moreno Lopez");
                i.putExtra("locutor","Marta Felipe Soria");
                startActivity(i);
                finish();
            }
        });
        elSonido4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Aurora Moreno Lopez");
                i.putExtra("locutor","Marta Felipe Soria");
                startActivity(i);
                finish();
            }
        });
        elSonido5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Aurora Moreno Lopez");
                i.putExtra("locutor","Marta Felipe Soria");
                startActivity(i);
                finish();
            }
        });
        elSonido6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Katerina Psegiannaki");
                i.putExtra("locutor","Monica Montoro");
                startActivity(i);
                finish();
            }
        });
        elSonido7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Marta Felipe Soria");
                i.putExtra("locutor","Manuel Cruz Lopez, Elena Pena Parrilla, Marta Felipe Soria");
                startActivity(i);
                finish();
            }
        });
        elSonido8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Bernardo Gomez");
                i.putExtra("locutor","Monica Montoro");
                startActivity(i);
                finish();
            }
        });
        elSonido9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Paloma Diez Temprano");
                i.putExtra("locutor","Manuel Cruz Lopez");
                startActivity(i);
                finish();
            }
        });
        elSonido10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Paloma Diez Temprano");
                i.putExtra("locutor","Manuel Cruz Lopez");
                startActivity(i);
                finish();
            }
        });

        elSonido11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Marta Felipe Soria");
                i.putExtra("locutor","Manuel Cruz Lopez");
                startActivity(i);
                finish();
            }
        });
        elSonido12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Paloma Diez Temprano");
                i.putExtra("locutor","Gonzalo Pendolema");
                startActivity(i);
                finish();
            }
        });
        elSonido13.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Julia Livaditi");
                i.putExtra("locutor","Monica Montoro");
                startActivity(i);
                finish();
            }
        });
        elSonido14.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Angel Munoz Jimenez");
                i.putExtra("locutor","Manuel Cruz Lopez");
                startActivity(i);
                finish();
            }
        });
        elSonido15.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Marta Felipe Soria");
                i.putExtra("locutor","Marta Felipe Soria");
                startActivity(i);
                finish();
            }
        });
        elSonido16.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Marta Felipe Soria");
                i.putExtra("locutor","Marta Felipe Soria");
                startActivity(i);
                finish();
            }
        });
        elSonido17.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Osvaldo Michellon");
                i.putExtra("locutor","Osvaldo Michellon");
                startActivity(i);
                finish();
            }
        });
        elSonido18.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Isabel Martin Ruiz");
                i.putExtra("locutor","Isabel Martin Ruiz, Damiana Ruiz");
                startActivity(i);
                finish();
            }
        });
        elSonido19.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Isabel Martin Ruiz");
                i.putExtra("locutor","Isabel Martin Ruiz, Damiana Ruiz");
                startActivity(i);
                finish();
            }
        });
        elSonido20.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(getApplicationContext(),AutobusLlegando.class);
                i.putExtra("autor","Fran Carrillo");
                i.putExtra("locutor","Raquel Sanchez");
                startActivity(i);
                finish();
            }
        });

    }

    public void eligeHistoria1min(MediaPlayer primerSonido, MediaPlayer segundaSonido, MediaPlayer tercerSonido, MediaPlayer cuartoSonido, MediaPlayer quintoSonido){


        Random rand = new Random();
        int eleccion = rand.nextInt(4);
        System.out.println("AQUI JUEEEEEEEEEEEE: " + eleccion);
        switch (eleccion) {
            case 0:


                primerSonido.start();
                break;
            case 1:


                segundaSonido.start();
                break;
            case 2:


                tercerSonido.start();
                break;
            case 3:


                cuartoSonido.start();
                break;
            case 4:


                quintoSonido.start();
                break;

    }

    }

    public void eligeHistoria2min(MediaPlayer primerSonido, MediaPlayer segundaSonido, MediaPlayer tercerSonido, MediaPlayer cuartoSonido){

        Random rand = new Random();
        int eleccion = rand.nextInt(3);
        System.out.println("AQUI JUEEEEEEEEEEEE LA DE DOS MIN: " + eleccion);
        switch (eleccion) {
            case 0:
                primerSonido.start();
                break;
            case 1:
                segundaSonido.start();
                break;
            case 2:
                tercerSonido.start();
                break;
            case 3:
                cuartoSonido.start();
                break;


        }

    }

    public void eligeHistoria3min(MediaPlayer primerSonido, MediaPlayer segundaSonido, MediaPlayer tercerSonido) {

        Random rand = new Random();
        int eleccion = rand.nextInt(2);
        System.out.println("AQUI JUEEEEEEEEEEEE LA DE TRES MIN: " + eleccion);
        switch (eleccion) {
            case 0:
                primerSonido.start();
                break;
            case 1:
                segundaSonido.start();
                break;
            case 2:
                tercerSonido.start();
                break;



        }
    }

    public static void mataEscuchandoHistoria(){

        Intent intent = new Intent(elContextico.getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        elContextico.startActivity(intent);
        //Cochinadita style
        elSonido1.stop();
        elSonido2.stop();
        elSonido3.stop();
        elSonido4.stop();
        elSonido5.stop();
        elSonido6.stop();
        elSonido7.stop();
        elSonido8.stop();
        elSonido9.stop();
        elSonido10.stop();
        elSonido11.stop();
        elSonido12.stop();
        elSonido13.stop();
        elSonido14.stop();
        elSonido15.stop();
        elSonido16.stop();
        elSonido17.stop();
        elSonido18.stop();
        elSonido19.stop();
        elSonido20.stop();
        //elSonido.stop();

//        finish();
    }

    public void eligeHistoria4min(MediaPlayer primerSonido, MediaPlayer segundaSonido) {

        Random rand = new Random();
        int eleccion = rand.nextInt(1);
        System.out.println("AQUI JUEEEEEEEEEEEE LA DE CUATRO MIN: " + eleccion);
        switch (eleccion) {
            case 0:
                primerSonido.start();
                break;
            case 1:
                segundaSonido.start();
                break;

        }
    }

}