package com.mubeenkhan.soccerzone;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRvListAdapterPopDeals extends RecyclerView.Adapter<MyRvListAdapterPopDeals.MyViewHolder> {
    Context c;
    List<Equipment> equipmentList;

    public MyRvListAdapterPopDeals(Context c, List<Equipment> equipmentList) {
        this.c = c;
        this.equipmentList = equipmentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(c).inflate(R.layout.popular_deals_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(equipmentList.get(position).getName());
        holder.description.setText(equipmentList.get(position).getDescription());
        holder.cost.setText(equipmentList.get(position).getCost());
        int x=Integer.parseInt(equipmentList.get(position).getCost());
        x=x-x/10;
        holder.discount.setText(Integer.toString(x));
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
        TextView name,description,cost,discount;
        LinearLayout ll;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_cd_title);
            description=itemView.findViewById(R.id.row_cd_text);
            cost=itemView.findViewById(R.id.row_cd_price1);
          //  image=itemView.findViewById(R.id.);
            ll=itemView.findViewById(R.id.row);
            discount=itemView.findViewById(R.id.row_cd_price2);

        }
    }
}
