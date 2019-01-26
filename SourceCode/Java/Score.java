package com.example.a2019nanyanewyear;

public class Score {
    private String username;
    private String playscore;


    public Score() {
    }

    public Score(String usename, String score) {
        this.username = usename;
        this.playscore = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usename) {
        this.username = usename;
    }

    public String getPlayscore() {
        return playscore;
    }

    public void setPlayscore(String playscore) {
        this.playscore = playscore;
    }
}
