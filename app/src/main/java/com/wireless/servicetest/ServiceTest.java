package com.wireless.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class ServiceTest extends Service {

    private Handler handler;
    private Runnable runnable;
    private final int runTime = 5000;

    @Override
    public void onCreate() {
        super.onCreate();

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                Toast.makeText(ServiceTest.this, "Hello", Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnable, runTime);
            }
        };
        handler.post(runnable);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}
