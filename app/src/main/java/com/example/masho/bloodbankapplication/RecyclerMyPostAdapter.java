package com.example.masho.bloodbankapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Masho on 10/5/2018.
 */

public class RecyclerMyPostAdapter extends RecyclerView.Adapter<RecyclerMyPostAdapter.MyViewHolder> {

    //in this we are creating reciept adapter so that we can generate reciept.
    Context context;
    ArrayList<ModelMyPost> profiles;

    public RecyclerMyPostAdapter(Context c , ArrayList<ModelMyPost> p)
    {
        context = c;
        profiles = p;
    }


    // inflate the custom layout of reciept list item to show on the activity context we pass. reciept_list_item is custom layout.++
    @Override
    public RecyclerMyPostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_myposts,parent,false));
    }

    //same as food item adpter
    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.username.setText(profiles.get(position).getUserName());
        holder.address.setText(profiles.get(position).getAddress());
        holder.address.setText(profiles.get(position).getDate_Of_Birth());
        holder.pno.setText(String.valueOf(profiles.get(position).getPhoneNumber()));
        holder.gender.setText(String.valueOf(profiles.get(position).getGender()));
        holder.bloodgrp.setText(String.valueOf(profiles.get(position).getBloodGroup()));
        holder.bloodtype.setText(String.valueOf(profiles.get(position).getBloodType()));
        holder.disease.setText(String.valueOf(profiles.get(position).getDisease()));
    }


    @Override
    public int getItemCount() {
        return profiles.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView username,address,pno,gender,disease,bloodtype,bloodgrp,dob;

        public MyViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.UserNames);
            address = itemView.findViewById(R.id.Address);
            pno= itemView.findViewById(R.id.Pno);
            gender = itemView.findViewById(R.id.Genders);
            disease = itemView.findViewById(R.id.Diseases);
            bloodtype = itemView.findViewById(R.id.BloodTypes);
            bloodgrp = itemView.findViewById(R.id.BloodGroups);
            dob = itemView.findViewById(R.id.DOBs);
        }
    }
}
