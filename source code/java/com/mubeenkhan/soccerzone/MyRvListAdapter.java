package com.mubeenkhan.soccerzone;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRvListAdapter extends RecyclerView.Adapter<MyRvListAdapter.MyViewHolder> {
    Context c;
    List<item> equipmentList;

    public MyRvListAdapter(Context c, List<item> equipmentList) {
        this.c = c;
        this.equipmentList = equipmentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(c).inflate(R.layout.equipment_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(equipmentList.get(position).getName());
        if(equipmentList.get(position).getItemsRemaining()>0){
            holder.availability.setText("In Stock");
        }
        else{
            holder.availability.setText("Out of Stock");

        }

        Picasso.get().load("http://"+ComputerIpAddress.localIP+"/smd_project/itemPictures/"+equipmentList.get(position).getName()+".jpg").into(holder.image);
        holder.cost.setText(Float.toString(equipmentList.get(position).getOriginalPrice()));

        Log.v("t2","yes");
        if(holder.ll!=null) {
            Log.v("t2","no");
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.v("t1","here");
//                    Intent intent=new Intent(view.getContext(),contactDetails.class);
//                    intent.putExtra("name",contactList.get(position).getName());
//                    intent.putExtra("phone",contactList.get(position).getPhone());
//                    intent.putExtra("email",contactList.get(position).getEmail());
//                    intent.putExtra("address",contactList.get(position).getAddress());

  //                  c.startActivity(intent);
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
        ImageView image;
        TextView name,availability,cost;
        LinearLayout ll;
        Button add;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageIv);
            name=itemView.findViewById(R.id.rowTemp);
            availability=itemView.findViewById(R.id.rowTemp11);
            cost=itemView.findViewById(R.id.rowTemp2);
          //  image=itemView.findViewById(R.id.);
            ll=itemView.findViewById(R.id.row);
            add=itemView.findViewById(R.id.rowTemp3);

        }
    }
}
