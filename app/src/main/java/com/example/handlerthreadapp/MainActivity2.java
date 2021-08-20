package com.example.handlerthreadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button startService;
    private Button playSong;
    private Button pauseSong;
    private Button stopService;
    private MusicService musicService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MusicBoundService musicBoundService = (MusicService.MusicBoundService) iBinder;
            musicService = musicBoundService.getMuiceService();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        startService = findViewById(R.id.btnstartService);
        playSong = findViewById(R.id.btnstartsong);
        pauseSong = findViewById(R.id.btnpauseSong);
        stopService = findViewById(R.id.btnstopService);
        startService.setOnClickListener(this);
        playSong.setOnClickListener(this);
        pauseSong.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnstartService:
                int song = getIntent().getIntExtra("Song",3);
                Intent intent = new Intent(this, MusicService.class);
                intent.putExtra("songForService",song);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.btnstartsong:
                musicService.play();

                break;
            case R.id.btnpauseSong:
                musicService.pause();
                break;
            case R.id.btnstopService:
                musicService.stop();
                break;
        }

    }
}