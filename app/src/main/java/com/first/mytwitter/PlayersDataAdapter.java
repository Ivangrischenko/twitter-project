package com.first.mytwitter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.first.mytwitter.TwitModel.Messages;

import java.util.List;

import pl.fanfatal.swipecontrollerdemo.R;


public class PlayersDataAdapter extends RecyclerView.Adapter<PlayersDataAdapter.MyViewHolder> {
    public List<Messages> messagesList;
    Context context;

    public PlayersDataAdapter(List<Messages> messagesList, Context context) {
        this.messagesList = messagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.row_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Messages messages = messagesList.get(position);
        holder.message.setText(messages.getTwitt());
        holder.date.setText(messages.getDate());



    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        TextView date;

        public MyViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message_add);
            date = itemView.findViewById(R.id.date_add);


        }



    }


}


