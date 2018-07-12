package com.first.mytwitter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   // private EditText add_massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_cat1) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);


// Set an EditText view to get user input
            final EditText input = new EditText(this);
            alert.setView(input);

            alert.setPositiveButton("Твитнуть", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                   Editable value = input.getText();
                    // Do something with value!

                }
            });


            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
