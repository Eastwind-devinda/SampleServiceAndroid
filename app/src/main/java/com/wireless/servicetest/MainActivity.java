package com.wireless.servicetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBtnStart = (Button) findViewById(R.id.btn_start);
        Button mBtnStop = (Button) findViewById(R.id.btn_stop);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().startService(new Intent(MainActivity.this, ServiceTest.class));
            }
        });

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().stopService(new Intent(MainActivity.this, ServiceTest.class));
            }
        });

    }
}
