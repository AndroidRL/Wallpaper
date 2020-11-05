package com.example.wallpaperapplication.Adepter_item;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallpaperapplication.MyPefrence;
import com.example.wallpaperapplication.R;
import com.example.wallpaperapplication.ViewpagerV.ViewPagerVActivity;

import java.util.ArrayList;

public class ListVAdepter extends RecyclerView.Adapter<ListVAdepter.MYHOLDER> {
    ArrayList<ListVItem> listVItems;
    Context context;
    private MyPefrence MyPrefrence;
    private int lastPosition = -1;

    public ListVAdepter(ArrayList<ListVItem> listVItems, Context context) {
        this.listVItems = listVItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MYHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_v_item, parent, false);
        return new MYHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYHOLDER holder, final int position) {
        Glide.with(context).load(listVItems.get(position).getPath()).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ViewPagerVActivity.class);
                intent.putExtra("datav", listVItems.get(position).getPath());
                MyPrefrence.setlistv(listVItems);
                intent.putExtra("vertical",position);
                context.startActivity(intent);

            }
        });

        setAnimation(holder.itemView,position);


    }

//loading Animation

    public  void setAnimation (View viewToAnimate, int position){

        if (position > lastPosition){

            ScaleAnimation animation = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0.5f);

            animation.setDuration(1500);
            viewToAnimate.setAnimation(animation);
            lastPosition = position;
        }
    }
    @Override
    public int getItemCount() {
        return listVItems.size();
    }


    public class MYHOLDER extends RecyclerView.ViewHolder {
        ImageView img;

        public MYHOLDER(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
