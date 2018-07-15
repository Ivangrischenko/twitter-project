package com.first.mytwitter.TwitModel;
//
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Messages extends RealmObject {


    @PrimaryKey
    private int id;

    private String date;

    private String twitt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTwitt() {
        return twitt;
    }

    public void setTwitt(String twitt) {
        this.twitt = twitt;
    }
}
