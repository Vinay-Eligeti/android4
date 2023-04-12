package com.example.practical_1_013;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public NotificationManager notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("Notification1","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableVibration(true);
                    channel.enableLights(true);
                    channel.setDescription("Notification for MainActivity");
                    notify.createNotificationChannel(channel);
        }
    }
    private NotificationCompat.Builder getNotifyBuilder()
    {
        Intent intent=new Intent(this,Notified.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"Notification1")
                .setContentTitle("Bhavana Jio")
                .setContentText("Hii Vinay")
                .setSmallIcon(R.drawable.ic_action_what)
                .setContentIntent(pendingIntent)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
                .setAutoCancel(true);
        return builder;

    }

    public void show(View view){
        NotificationCompat.Builder builder=getNotifyBuilder();
        notify.notify(1,builder.build());

    }
}