package com.example.handlerthreadapp;

public class SongModel {
    private int song;
    private String songName;
    private int songImage;

    public SongModel(int song, String songName, int songImage) {
        this.song = song;
        this.songName = songName;
        this.songImage = songImage;
    }

    public int getSong() {
        return song;
    }

    public String getSongName() {
        return songName;
    }

    public int getSongImage() {
        return songImage;
    }
}
