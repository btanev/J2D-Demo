package com.java2days.j2ddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import timber.log.Timber;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Timber.tag(this.getClass().getSimpleName());

        setContentView(R.layout.activity_weather);

        Timber.d("Activity created...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        Timber.v("Menu item selected... ");

        switch (item.getItemId()) {
            case R.id.menu_simulate_crash:
                Timber.i("Will crash!");
                throw new RuntimeException("Crash! Boom! Bang!");
            case R.id.menu_simulate_non_fatal:
                Timber.i("Will NOT crash!");
                Timber.w(new RuntimeException("Crash! Boom! Bang!"), "A fake message");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
