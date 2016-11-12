package com.java2days.j2ddemo;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.timber.StethoTree;

import timber.log.Timber;

/**
 * Created by bobytanev on 11/12/16.
 */

public class J2DDemoDebugApplication extends J2DDemoApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        // init Stetho
        Stetho.initializeWithDefaults(this);

        // init debug Timber
        Timber.plant(new Timber.DebugTree());
        Timber.plant(new StethoTree());
    }
}
