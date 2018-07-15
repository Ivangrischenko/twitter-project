package com.first.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.first.anew.Players.MyHelper;
import com.first.anew.Players.Player;

import io.realm.Realm;
import pl.fanfatal.swipecontrollerdemo.R;

public class Main2Activity extends AppCompatActivity {


    EditText edit_title, edit_content, edit_link;
    Button button;
    Realm realm1;
    String mTitle, mContent, mLink;
    MyHelper myHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button) findViewById(R.id.b1);
        edit_title = (EditText) findViewById(R.id.edit_title);
        edit_content = (EditText) findViewById(R.id.edit_content);
        edit_link = (EditText)findViewById(R.id.edit_link);

        realm1 = Realm.getDefaultInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitle = edit_title.getText().toString();
                mContent = edit_content.getText().toString();
                mLink = edit_link.getText().toString();

                if(!mTitle.isEmpty() && !mContent.isEmpty() && !mLink.isEmpty()){
                    Player player = new Player();
                    player.setTitle(mTitle);
                    player.setContent(mContent);
                    player.setLink(mLink);

                    myHelper = new MyHelper (realm1);
                    myHelper.save(player);

                    Toast.makeText(Main2Activity.this, "Удалось", Toast.LENGTH_SHORT).show();

                   // edit_name.setText("");

                    startActivity(new Intent(Main2Activity.this, MainActivity.class));
                }
            }
        });
    }


}


