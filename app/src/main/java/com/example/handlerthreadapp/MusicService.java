package com.example.handlerthreadapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowInsetsAnimation;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    int song=0;
    private final String TAG="check";

    public MusicService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG,"On Create in service");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"On Destroy in service");
    }

    public void play() {
        mediaPlayer.start();
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        song = intent.getIntExtra("songForService",5);
        mediaPlayer=MediaPlayer.create(this,song);
        Log.v(TAG,"On Bind");
        return new MusicBoundService();
    }

    public class MusicBoundService extends Binder{

        public MusicService getMuiceService(){
            return MusicService.this;
        }
    }
}