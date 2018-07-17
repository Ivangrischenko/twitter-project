package com.first.mytwitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.first.mytwitter.TwitModel.MyHelper;

import io.realm.Realm;
import pl.fanfatal.swipecontrollerdemo.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_message_new, edit_date_new;

    Button update_twitt;
    Realm realm;
    int id;
    String message_new, date_new;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update2 );

        edit_message_new = (EditText) findViewById( R.id.edit_message1 );
        edit_date_new = (EditText) findViewById( R.id.edit_date1 );

        update_twitt = (Button) findViewById( R.id.b11 );

        //get data from main activity
        id = Integer.parseInt(getIntent().getStringExtra( "key_id" ));
        message_new = getIntent().getStringExtra( "key_message" );
        date_new = getIntent().getStringExtra( "key_date" );



        edit_message_new.setText( message_new );
        edit_date_new.setText( date_new );

        realm = Realm.getDefaultInstance();


        update_twitt.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        myHelper = new MyHelper( realm );
        myHelper.update( id, edit_message_new.getText().toString(),
                edit_date_new.getText().toString());


        finish();


    }
}
