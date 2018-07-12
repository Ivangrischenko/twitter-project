package com.first.mytwitter.TwitModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Messages extends RealmObject {


    @PrimaryKey
    private int date;

    private String text;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
