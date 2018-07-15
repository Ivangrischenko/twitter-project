package com.first.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.first.anew.Players.MyHelper;

import io.realm.Realm;
import pl.fanfatal.swipecontrollerdemo.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_title_new, edit_content_new, edit_link_new;

    Button update_twitt;
    Realm realm;
    int id;
    String title_new, content_new, link_new;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update2 );

        edit_title_new = (EditText) findViewById( R.id.edit_title_new );
        edit_content_new = (EditText) findViewById( R.id.edit_content_new );
        edit_link_new = (EditText) findViewById( R.id.edit_link_new );
        update_twitt = (Button) findViewById( R.id.b1_new );

        //get data from main activity
        id = Integer.parseInt(getIntent().getStringExtra( "key_id" ));
        title_new = getIntent().getStringExtra( "key_title" );
        content_new = getIntent().getStringExtra( "key_content" );
        link_new = getIntent().getStringExtra( "key_link" );


        edit_title_new.setText( title_new );
        edit_content_new.setText( content_new );
        edit_link_new.setText( link_new );

        realm = Realm.getDefaultInstance();


        update_twitt.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        myHelper = new MyHelper( realm );
        myHelper.update( id, edit_title_new.getText().toString(),
                edit_content_new.getText().toString(),
                edit_link_new.getText().toString() );
        edit_link_new.setText( "" );
        edit_content_new.setText( "" );
        edit_link_new.setText( "" );
        finish();


    }
}
