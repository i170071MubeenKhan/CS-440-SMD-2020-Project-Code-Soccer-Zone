package com.mubeenkhan.soccerzone;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRvListAdapterWeeklyNotifications extends RecyclerView.Adapter<MyRvListAdapterWeeklyNotifications.MyViewHolder> {
    Context c;
    List<Equipment> equipmentList;

    public MyRvListAdapterWeeklyNotifications(Context c, List<Equipment> equipmentList) {
        this.c = c;
        this.equipmentList = equipmentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(c).inflate(R.layout.weekly_notifications_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(equipmentList.get(position).getName());
        holder.description.setText(equipmentList.get(position).getDescription());
        Log.v("t2","yes");
        if(holder.ll!=null) {
            Log.v("t2","no");
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.v("t1","here");
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if(equipmentList==null)
            return 0;
        return equipmentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        LinearLayout ll;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_wn_title);
            description=itemView.findViewById(R.id.row_wn_text);

        }
    }
}
