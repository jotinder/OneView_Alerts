package com.oneview.oneview_alerts;


//import com.google.firebase.messaging.FirebaseMessaging;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.IOException;

public class MyFirebaseMessagingService extends FirebaseMessagingService  {

    private SQLiteDB dbHelper;
    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG,"FROM:" + remoteMessage.getFrom());
        try {
            dbHelper.insertNotification(remoteMessage.getNotification().getBody());
            //Check if the message contains data
        }
        catch (Exception e){
            Toast.makeText(MyFirebaseMessagingService.this,"Unable to insert into SQLite DB",Toast.LENGTH_SHORT).show();
        }

        if(remoteMessage.getData().size() > 0){
            Log.d(TAG,"Message data: " + remoteMessage.getData());


        }

        //Check if the message contains notification
        if(remoteMessage.getNotification() != null){
            Log.d(TAG,"Message body: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }

    }

    /**
     * Display the notification
     * @param body
     */
    private void sendNotification(String body) {
        Intent intent = new Intent(this,HomeScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        //Set sound of the notification

        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifibuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase Cloud Messaging Service")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifibuilder.build());
    }
}

