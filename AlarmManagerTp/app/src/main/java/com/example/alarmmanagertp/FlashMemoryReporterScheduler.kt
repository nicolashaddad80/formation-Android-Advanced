/*
 * 2021 Developed by Renault SW Labs,
 * an affiliate of RENAULT s.a.s. which holds all intellectual property rights.
 * Use of this software is subject to a specific license granted by Renault s.a.s.
 */

package com.example.alarmmanagertp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log

class FlashMemoryReporterScheduler(
    context: Context
){
    private val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    private val alarmIntent = Intent(context, FlashMemoryWearLevelAlarmReceiver::class.java).
        let{ intent ->
        PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_NO_CREATE)
    }

    init {
        Log.d("Alarm", "==========>Initializing Alarm <======================")
        alarmMgr.setInexactRepeating(
            AlarmManager.RTC,
            System.currentTimeMillis(),
            5000,
            alarmIntent
        )
    }
}
