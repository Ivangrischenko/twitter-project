package com.first.mytwitter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.first.mytwitter.Applycation.Countries;

import com.first.mytwitter.Applycation.RetrofitClientInstance;
import com.first.mytwitter.TwitModel.Messages;
import com.first.mytwitter.TwitModel.MyHelper;

import java.util.ArrayList;
import java.util.List;


import io.realm.Realm;
import pl.fanfatal.swipecontrollerdemo.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    //private String pl = getIntent().getExtras().getString("testNameData");
    MyHelper myHelper;
    RecyclerView recyclerView;
    List<Messages> messagesList;
    PlayersDataAdapter mAdapter;
    SwipeController swipeController = null;
    Realm realm2;
    int id;


    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView) ;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        realm2 = Realm.getDefaultInstance();

        myHelper = new MyHelper(realm2);
        messagesList = new ArrayList<>();




        //retrofit init

        Countries service = RetrofitClientInstance.getRetrofitInstance().
                create(Countries.class);

        Call<List<Messages>> call = service.getCountries();
        call.enqueue(new Callback<List<Messages>>() {

            @Override
            public void onResponse(@NonNull Call<List<Messages>> call, @NonNull Response<List<Messages>> response) {



                for (int i = 0; i < response.body().size(); i++) {


                    Messages messages = new Messages();
                    messages.setName( response.body().get( i ).getName() );
                    myHelper.save( messages );
                   // myHelper.update( i , messages.getName());

                }


                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Messages>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        messagesList = myHelper.getAllRealmM();


        mAdapter = new PlayersDataAdapter( messagesList, this);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(final int position) {

                realm2.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {


                        // remove a single object

                            Messages messages = messagesList.get( position );
                        messages.deleteFromRealm();


                    }
                });

                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
            }

            @Override
            public void onLeftClicked (final int position){
                Intent intent = new Intent( MainActivity.this, UpdateActivity.class );
                intent.putExtra( "key_id", messagesList.get( position).getId() + "" );
                intent.putExtra( "key_message", messagesList.get( position).getName() );
               // intent.putExtra( "key_date", messagesList.get( position).getDate() );


                MainActivity.this.startActivity( intent );

            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });


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
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    protected void onResume(){
        super.onResume();
        mAdapter.notifyDataSetChanged();
        Log.e ( "ppppp", "рестартттттттт");
    }*/
}