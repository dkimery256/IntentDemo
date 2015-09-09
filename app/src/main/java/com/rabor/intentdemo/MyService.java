package com.rabor.intentdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "com.rabor.intentdemo";

    public MyService() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand method called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++) {
                    long futureTime = System.currentTimeMillis() + 5000;
                    while (System.currentTimeMillis() < futureTime) {
                        synchronized (this) {
                            try {
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "Service is doing something");
                            } catch (Exception e) {

                            }
                        }
                    }
                }
            }
        };

        // put all your code in the thread and start it
        Thread myThread = new Thread(r);
        myThread.start();

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
