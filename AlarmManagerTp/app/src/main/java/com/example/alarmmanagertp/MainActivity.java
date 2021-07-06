package com.example.alarmmanagertp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alarmmanagertp.FlashMemoryReporterScheduler;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FlashMemoryWearLevelAlarmReceiver();
        new FlashMemoryReporterScheduler(this);

    }
}
