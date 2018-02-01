package com.evollu.react.fcm;

import android.app.AlarmManager;
import android.content.Context;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.BroadcastReceiver;


public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            PendingIntent pi = PendingIntent.getService(context, 0, new Intent(context, MessagingService.class), PendingIntent.FLAG_UPDATE_CURRENT);
            am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 100, 100, pi);
        }
    }
}
