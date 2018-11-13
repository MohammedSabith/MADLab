package com.example.iamgroot.musicer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

@SuppressWarnings("ALL")
public class MusicService extends Service {

    MediaPlayer music;

    @Override
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this,R.raw.ovhor);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        music.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        music.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
