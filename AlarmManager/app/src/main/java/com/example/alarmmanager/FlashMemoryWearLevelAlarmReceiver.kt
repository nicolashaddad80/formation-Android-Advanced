/*
 * 2021 Developed by Renault SW Labs,
 * an affiliate of RENAULT s.a.s. which holds all intellectual property rights.
 * Use of this software is subject to a specific license granted by Renault s.a.s.
 */
package com.example.alarmmanagertp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class FlashMemoryWearLevelAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.d("Lemonad Flash Memory Wear Level", "=====================================>Alarm Received<============================================")
        Toast.makeText(context, "Alarm !!!!!!!!!!", Toast.LENGTH_LONG).show()
    }
}
