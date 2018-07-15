package com.first.anew;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.first.anew.Players.Player;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import pl.fanfatal.swipecontrollerdemo.R;


public class PlayersDataAdapter extends RecyclerView.Adapter<PlayersDataAdapter.MyViewHolder> {
    public List<Player> playerList;
    Context context;

    public PlayersDataAdapter(List<Player> playerList, Context context) {
        this.playerList = playerList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.title.setText(player.getTitle());
        holder.content.setText(player.getContent());
        holder.link.setText(player.getLink());

    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        TextView link;





        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            content = itemView.findViewById(R.id.content);
            link = itemView.findViewById(R.id.link);






        }



    }


}


