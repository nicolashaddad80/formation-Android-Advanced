package com.example.alarmmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarmmanagertp.FlashMemoryReporterScheduler
import com.example.alarmmanagertp.FlashMemoryWearLevelAlarmReceiver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FlashMemoryWearLevelAlarmReceiver()
        FlashMemoryReporterScheduler(this)
    }
}
