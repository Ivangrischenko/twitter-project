package com.first.mytwitter.Applycation;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication2 extends Application {



    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init( this );

        RealmConfiguration defconfigurare = new RealmConfiguration.Builder().name( "defApplyc2" ).build();

        Realm.setDefaultConfiguration( defconfigurare );


    }
}
