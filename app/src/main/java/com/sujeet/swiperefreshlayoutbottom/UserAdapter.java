package com.sujeet.swiperefreshlayoutbottom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<UserModel> userModels;
    Context context;

    public UserAdapter(List<UserModel> userModels, Context context) {
        this.userModels = userModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userlist, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserModel model = userModels.get(position);
        holder.userName.setText(model.getUserNmae());
        holder.userMobile.setText(model.getUserMobile());
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView userMobile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.userName);
            userMobile = (TextView)itemView.findViewById(R.id.userMobile);
        }
    }
}
