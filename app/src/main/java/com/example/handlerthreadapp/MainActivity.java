package com.example.handlerthreadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {
    private ArrayList<SongModel> modelList=new ArrayList<>();
    private RecyclerView recyclerView;
    private ClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        setDataForAdapter();
        sendData();
    }

    private void sendData() {
        SongAdapter adapter=new SongAdapter(modelList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void setDataForAdapter() {
        modelList.add(new SongModel(R.raw.shivsaktisong,"Shiv sakti song",R.drawable.shivsakti));
        modelList.add(new SongModel(R.raw.soormasong,"Soorma Anthem song",R.drawable.sooram));
        modelList.add(new SongModel(R.raw.chotisiasasong,"Dil hai chota sa song",R.drawable.chotisiasa));
        modelList.add(new SongModel(R.raw.brothersong,"Brother Anthem Song",R.drawable.brother));
        modelList.add(new SongModel(R.raw.ziddisong,"Dil ye ziddi hai song",R.drawable.marrycome));
        modelList.add(new SongModel(R.raw.shivsaktisong,"Shiv sakti song",R.drawable.shivsakti));
        modelList.add(new SongModel(R.raw.soormasong,"Soorma Anthem song",R.drawable.sooram));
        modelList.add(new SongModel(R.raw.chotisiasasong,"Dil hai chota sa song",R.drawable.chotisiasa));
        modelList.add(new SongModel(R.raw.brothersong,"Brother Anthem Song",R.drawable.brother));
        modelList.add(new SongModel(R.raw.ziddisong,"Dil ye ziddi hai song",R.drawable.marrycome));
    }

    @Override
    public void click(SongModel model, int position) {
        int song=model.getSong();
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("Song",song);
        startActivity(intent);

    }
}