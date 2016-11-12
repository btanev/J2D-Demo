package com.java2days.j2ddemo;

import android.app.Application;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Created by bobytanev on 11/12/16.
 */

public class J2DDemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.USE_CRASHLYTICS) {
            Fabric.with(this, new Crashlytics());
            Timber.plant(new CrashReportingTree());
        }
    }

    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected boolean isLoggable(String tag, int priority) {
            return priority > Log.INFO;
        }

        @Override protected void log(int priority, String tag, String message, Throwable t) {
            Crashlytics.log(priority, tag, message);
            if (t != null) {
                // log non fatal exception
                Crashlytics.logException(t);
            }
        }
    }
}
