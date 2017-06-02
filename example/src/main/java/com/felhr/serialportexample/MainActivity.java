package com.felhr.serialportexample;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    /*
     * Notifications from UsbService will be received here.
     */

    static String laVariable;// alguien ,  nadie , persona atenta
    static TextView elTexto;
    MediaPlayer elSonido;
    ImageView laImagen;
    Button contestarBtn;

    static boolean yaPaso = false;
    static boolean yaContesto = false;
    static boolean yaEligio = false;
    static boolean yaBusLLegando = false;
    static boolean yaVaAColgar = false;


    private UsbService usbService;
    private static TextView display;
    private EditText editText;
    private MyHandler mHandler;
    static Context elContextico;

    public static void reiniciarApp(){
       // Intent intent = new Intent(, MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
         //       | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //elContextico.startActivity(intent);

    }


    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case UsbService.ACTION_USB_PERMISSION_GRANTED: // USB PERMISSION GRANTED
                    Toast.makeText(context, "USB Lijta", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_PERMISSION_NOT_GRANTED: // USB PERMISSION NOT GRANTED
                    Toast.makeText(context, "USB permiso sin pedir", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_NO_USB: // NO USB CONNECTED
                    Toast.makeText(context, "No conectado Arduino", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_DISCONNECTED: // USB DISCONNECTED
                    Toast.makeText(context, "USB desconectado", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_NOT_SUPPORTED: // USB NOT SUPPORTED
                    Toast.makeText(context, "USB aparato sin soporte", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


  private final ServiceConnection usbConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1) {
            usbService = ((UsbService.UsbBinder) arg1).getService();
            usbService.setHandler(mHandler);
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            usbService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();//esconder las barras                elSonido.stop();

        mHandler = new MyHandler(this);

        display = (TextView) findViewById(R.id.textView1);
        //display.setVisibility(View.GONE);

        yaPaso = false;
        yaContesto = false;
        yaEligio = false;
        yaBusLLegando = false;
        yaVaAColgar = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        setFilters();  // Start listening notifications from UsbService
        startService(UsbService.class, usbConnection, null); // Start UsbService(if it was not started before) and Bind it

        yaPaso = getIntent().getBooleanExtra("yapaso",false);
        yaEligio = getIntent().getBooleanExtra("yaeligio",false);
        yaContesto = getIntent().getBooleanExtra("yacontesto",false);
        yaBusLLegando = getIntent().getBooleanExtra("yabusllegando",false);
        yaVaAColgar = getIntent().getBooleanExtra("yavaacolgar",false);
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(mUsbReceiver);
        unbindService(usbConnection);



    }

    public void tostadas (String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), LlamadaActivity .class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void startService(Class<?> service, ServiceConnection serviceConnection, Bundle extras) {
        if (!UsbService.SERVICE_CONNECTED) {
            Intent startService = new Intent(this, service);
            if (extras != null && !extras.isEmpty()) {
                Set<String> keys = extras.keySet();
                for (String key : keys) {
                    String extra = extras.getString(key);
                    startService.putExtra(key, extra);
                }
            }
            startService(startService);
        }
        Intent bindingIntent = new Intent(this, service);
        bindService(bindingIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }


    private void setFilters() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbService.ACTION_USB_PERMISSION_GRANTED);
        filter.addAction(UsbService.ACTION_NO_USB);
        filter.addAction(UsbService.ACTION_USB_DISCONNECTED);
        filter.addAction(UsbService.ACTION_USB_NOT_SUPPORTED);
        filter.addAction(UsbService.ACTION_USB_PERMISSION_NOT_GRANTED);
        registerReceiver(mUsbReceiver, filter);
    }

    /*
     * This handler will be passed to UsbService. Data received from serial port is displayed through this handler
     */


    private static class MyHandler extends Handler {

        private final WeakReference<MainActivity> mActivity;
        public static String serialIn;

        public MyHandler(MainActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UsbService.MESSAGE_FROM_SERIAL_PORT:
                    String data = (String) msg.obj;
                    data = data.trim();//limpiando la data

                  //  Toast.makeText(mActivity.get(), "Recibiendo por serial", Toast.LENGTH_SHORT).show();



                    mActivity.get().display.append(data);

//                    Toast.makeText(mActivity.get().getApplicationContext(), data , Toast.LENGTH_SHORT).show();

                    if (data.equals("a") && yaPaso == false) {
                        Toast.makeText(mActivity.get().getApplicationContext(), "Entro una A", Toast.LENGTH_SHORT).show();
                        yaPaso = true;
                        mActivity.get().tostadas("arranco");
                    }

                    if (data.equals("b") && yaPaso == true && yaContesto == false) {
                        Toast.makeText(mActivity.get().getApplicationContext(), "Entro una B", Toast.LENGTH_SHORT).show();
                        yaContesto = true;
                        LlamadaActivity.pasaAHistorias();
                    }

                    //Colgando si no han elegido una historia
                    if (data.equals("c") && yaPaso == true && yaContesto == true && yaEligio == false) {
                        Toast.makeText(mActivity.get().getApplicationContext(), "Entro una C", Toast.LENGTH_SHORT).show();
                        SystemClock.sleep(10000);
                        HistoriaActividad.mataHistorias();//reiniciando a primer actividad
                        yaContesto = false;
                        yaPaso = false;
                        yaEligio = false;
                    }

                    //Colgando si  esta escuchando una historia
                    if (data.equals("c") && yaPaso == true && yaContesto == true && yaEligio == true) {
                        Toast.makeText(mActivity.get().getApplicationContext(), "Entro una C", Toast.LENGTH_SHORT).show();
                        SystemClock.sleep(10000);
                        EscuchaHistoriasActividad.mataEscuchandoHistoria();//reiniciando a primer actividad
                        yaContesto = false;
                        yaPaso = false;
                        yaEligio = false;
                    }

                    //Colgando si el autobus esta llegando
                    /*if (data.equals("c") && yaPaso == true && yaContesto == true && yaEligio == true && yaBusLLegando == true) {
                        Toast.makeText(mActivity.get().getApplicationContext(), "Entro una C", Toast.LENGTH_SHORT).show();
                        //SystemClock.sleep(10000);
                        AutobusLlegando.mataBusLlegando();//reiniciando a primer actividad
                        yaContesto = false;
                        yaPaso = false;
                        yaEligio = false;
                        yaBusLLegando = false;
                    }*/

                    //Colgando si esta dond tiene q colgar
                    if (data.equals("c") && yaPaso == true && yaContesto == true && yaEligio == true && yaBusLLegando == true && yaVaAColgar == true) {
                        Toast.makeText(mActivity.get().getApplicationContext(), "Entro una C", Toast.LENGTH_SHORT).show();
                        //SystemClock.sleep(4000);
                        CuelgActivity.mataColgar();//reiniciando a primer actividad
                        yaContesto = false;
                        yaPaso = false;
                        yaEligio = false;
                        yaBusLLegando = false;
                        yaVaAColgar = false;
                    }


                    //COCHINADA SALVA CULOS
/*                    if(data != null && yaPaso == false){
                        mActivity.get().tostadas("arranco");
                        yaPaso = true;
                    }
*/

                    break;
            }
        }
    }
}