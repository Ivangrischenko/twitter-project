package com.first.mytwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.first.mytwitter.TwitModel.Messages;
import com.first.mytwitter.TwitModel.MyHelper;

import io.realm.Realm;
import pl.fanfatal.swipecontrollerdemo.R;


public class Main2Activity extends AppCompatActivity {


    EditText edit_message;
    Button button;
    Realm realm1;
    String mMessage;
    MyHelper myHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main2);

        button = (Button) findViewById(R.id.b1);
        edit_message = (EditText) findViewById(R.id.edit_message);

        realm1 = Realm.getDefaultInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessage = edit_message.getText().toString();

                if(!mMessage.isEmpty() ){
                    Messages messages = new Messages();

                    messages.setName(mMessage);

                    myHelper = new MyHelper (realm1);
                    myHelper.save(messages);

                    Toast.makeText(Main2Activity.this, "Удалось", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Main2Activity.this, MainActivity.class));
                }
            }
        });
    }


}