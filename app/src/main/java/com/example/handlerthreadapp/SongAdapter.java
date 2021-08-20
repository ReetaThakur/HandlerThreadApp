package com.example.handlerthreadapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ArrayList<SongModel> modelList;
    private ClickListener clickListener;
    public SongAdapter(ArrayList<SongModel> modelList,ClickListener clickListener){
        this.modelList=modelList;
        this.clickListener=clickListener;

    }
    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_layout,parent,false);
        return new SongViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        SongModel model=modelList.get(position);
        holder.setData(model);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView songName;
        private TextView songId;
        private ClickListener clickListener;
        private ConstraintLayout constraintLayout;

        public SongViewHolder(@NonNull View itemView,ClickListener clickListener) {
            super(itemView);
            this.clickListener=clickListener;
            imageView=itemView.findViewById(R.id.imageView);
            songName=itemView.findViewById(R.id.txtnameOfSong);
            songId=itemView.findViewById(R.id.songId);
            constraintLayout=itemView.findViewById(R.id.constraintLayout);
        }
        public void setData(SongModel model){
            imageView.setImageResource(model.getSongImage());
            songName.setText(model.getSongName());
            songId.setText(model.getSong()+"");
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.click(model,getAdapterPosition());
                }
            });
        }
    }
}
