package com.devxnow.recyclerviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.AdapterClassViewHolder> {

    ModelClass[] modelClasses;

    public AdapterClass(ModelClass[] modelClasses) {
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public AdapterClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new AdapterClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClassViewHolder holder, int position) {
        holder.Name.setText(modelClasses[position].personName);
        holder.Message.setText(modelClasses[position].personaText);
        holder.Time.setText(modelClasses[position].personTime);
        holder.Picture.setImageResource(modelClasses[position].personDp);
    }

    @Override
    public int getItemCount() {
        return modelClasses.length;
    }

    public class AdapterClassViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Message,Time;
        ImageView Picture;
        public AdapterClassViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.friendName);
            Message=itemView.findViewById(R.id.friendMessage);
            Time=itemView.findViewById(R.id.FriendTime);
            Picture=itemView.findViewById(R.id.dp);
        }
    }
}
