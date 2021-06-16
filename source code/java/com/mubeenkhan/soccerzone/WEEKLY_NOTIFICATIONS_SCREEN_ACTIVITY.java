package com.mubeenkhan.soccerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY extends AppCompatActivity {
    RecyclerView rv;
    TextView add;
    MyRvListAdapterWeeklyNotifications adapter;
    ArrayList<Equipment> equipmentArrayList = new ArrayList<Equipment>();
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_notifications);
        if (counter == 0) {
            equipmentArrayList = new ArrayList<Equipment>();
            counter++;
        }

        ImageView menu=findViewById(R.id.weakly_notification_menu);
      /*  menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup=new PopupMenu(MAIN_SCREEN_ACTIVITY.this,view);
                popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) MAIN_SCREEN_ACTIVITY.this);
                popup.inflate(R.menu.dropdown_menu);
                popup.show();
            }
        });
        */

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup=new PopupMenu(getApplicationContext(),view);
                popup.inflate(R.menu.dropdown_menu);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.main_menu:
                                startActivity(new Intent(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this, MAIN_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.popular_deals:
                                startActivity(new Intent(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this, POPULAR_DEAL_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.notifications:
                                return true;
                            case R.id.purchase_history:
                                startActivity(new Intent(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this, ORDER_HISTORY_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.sign_out:
                                startActivity(new Intent(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this, LOGIN_ACTIVITY.class));
                                return true;
                            default:
                                return false;

                        }
                    }
                });
            }

        });

        ImageView cart=findViewById(R.id.weakly_notification_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this,CHECKOUT_SCREEN_ACTIVITY.class));
            }
        });
        equipmentArrayList.add(new Equipment("Adidas Predator 20.3","Show no mercy, feel no remorse and push the rules to the limit in the adidas Predator 20.3 FG.", "Adidas", "studs", "In stock", "15,999", 0));
        equipmentArrayList.add(new Equipment("Nike Footabll Flight Premier League - White/Laser","Nike's revolutionary football exclusive to the league offers improved aerodynamics ", "Nike", "football", "In stock", "5,499", 0));
        equipmentArrayList.add(new Equipment("Puma Future 5.1 Netfit FG/AG", "Break apart defences with the PUMA Future 5.1 NETFIT FG/AG football shoes.","Puma", "studs", "In stock", "22,999", 0));

        rv = findViewById(R.id.weakly_notification_rvList);
        // add=findViewById(R.id.address);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this);
        rv.setLayoutManager(manager);
        adapter = new MyRvListAdapterWeeklyNotifications(WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.this, equipmentArrayList);
        rv.setAdapter(adapter);

    }
}
