package com.mubeenkhan.soccerzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        startActivity(new Intent(MainActivity.this,MAIN_SCREEN_ACTIVITY.class));
    }
}