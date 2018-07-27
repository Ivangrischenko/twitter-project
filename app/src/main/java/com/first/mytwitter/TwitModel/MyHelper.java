package com.first.mytwitter.TwitModel;

import android.support.annotation.NonNull;
import android.util.Log;

import com.first.mytwitter.TwitModel.Messages;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyHelper  {
    Realm realm;

    // final RealmResults<Player> players = realm.where(Player.class).findAll();

    public MyHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final Messages messages){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.d ( "ppppp", "урааааа");
                    Number currentIdSum = realm.where(Messages.class).max("id");
                    int nextId;
                    if (currentIdSum==null){
                        nextId = 1;
                    }else {
                        nextId = currentIdSum.intValue() + 1;
                    }
                    messages.setId(nextId);
                    Messages p = realm.copyToRealm(messages);
                }else {
                    Log.e ( "ppppp", "data");
                }

            }
        });
    }



    //select data from
    public List<Messages> getAllRealmM(){
        List<Messages> messagesList = realm.where(Messages.class).findAll();
        return messagesList;
    }

    //update
    public  void update(final int id, final String twitt) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                Messages messages = realm.where(Messages.class)
                        .equalTo("id", id)
                        .findFirst();

                assert messages != null;
                messages.setName(twitt);
               // messages.setDate(date);




            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e( "ppppp", "update success");


            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(@NonNull Throwable error) {
                error.printStackTrace();

            }
        });

    }



}
