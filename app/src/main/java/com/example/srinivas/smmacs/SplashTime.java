package com.example.srinivas.smmacs;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by srinivas on 12/18/17.
 */

public class SplashTime extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000 );
    }
}
