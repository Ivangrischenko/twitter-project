package com.first.mytwitter.Applycation;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DefAppl extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(this);

        RealmConfiguration defconf = new RealmConfiguration.Builder().name("defApp").build();

        Realm.setDefaultConfiguration(defconf);
    }
}
