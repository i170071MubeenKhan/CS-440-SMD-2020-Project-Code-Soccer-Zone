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

public class MyRvListAdapterOrderHistory extends RecyclerView.Adapter<MyRvListAdapterOrderHistory.MyViewHolder> {
    Context c;
    List<Equipment> equipmentList;

    public MyRvListAdapterOrderHistory(Context c, List<Equipment> equipmentList) {
        this.c = c;
        this.equipmentList = equipmentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(c).inflate(R.layout.order_history_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(equipmentList.get(position).getName());
        holder.availability.setText(equipmentList.get(position).getAvailability());
        holder.cost.setText(equipmentList.get(position).getCost());
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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_oh_title);
            availability=itemView.findViewById(R.id.row_oh_availability);
            cost=itemView.findViewById(R.id.row_oh_price1);
          //  image=itemView.findViewById(R.id.);
            ll=itemView.findViewById(R.id.row);

        }
    }
}
