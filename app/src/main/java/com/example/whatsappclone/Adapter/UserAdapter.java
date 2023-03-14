package com.example.whatsappclone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsappclone.ChatDetailActivity;
import com.example.whatsappclone.Model.User;
import com.example.whatsappclone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    ArrayList<User> list;
    Context context;

    public UserAdapter(ArrayList<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_show_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=list.get(position);
        Picasso.get().load(user.getProfilePic()).placeholder(R.drawable.kohli).into(holder.profileImg);
        holder.userName.setText(user.getUserName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChatDetailActivity.class);
                intent.putExtra("userId",user.getUserId());
                intent.putExtra("userName",user.getUserName());
                intent.putExtra("profilePic",user.getUserId());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profileImg;
        TextView userName,lastMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg=itemView.findViewById(R.id.profile_image);
            userName=itemView.findViewById(R.id.txt_userName);
            lastMessage=itemView.findViewById(R.id.txt_lastMessage);
        }
    }
}
