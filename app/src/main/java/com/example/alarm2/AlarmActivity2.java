package com.example.alarm2;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmActivity2 extends AppCompatActivity {
    Ringtone ringtone;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        TextView txtView = findViewById(R.id.textView2);
        TextView txtView2 = findViewById(R.id.textView3);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String s1 = df.format(c.getTime());
        SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
        String s2 = df2.format(c.getTime());
        txtView.setText(s1);
        txtView2.setText(s2);

        Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(this, notificationUri);
        if (ringtone == null){
            notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            ringtone = RingtoneManager.getRingtone(this, notificationUri);
        }
        if(ringtone != null){
            ringtone.play();
        }
    }

    @Override
    protected void onDestroy() {
        if (ringtone != null && ringtone.isPlaying()){
            ringtone.stop();
        }
        super.onDestroy();
    }
}