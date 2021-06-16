package com.mubeenkhan.soccerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CHECKOUT_SCREEN_ACTIVITY extends AppCompatActivity {
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        order=findViewById(R.id.orderButton);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CHECKOUT_SCREEN_ACTIVITY.this, "Order Successfully Placed", Toast.LENGTH_LONG).show();
                startActivity(new Intent(CHECKOUT_SCREEN_ACTIVITY.this,MAIN_SCREEN_ACTIVITY.class));
            }
        });
        Button menu=findViewById(R.id.menuCheck);
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
                                startActivity(new Intent(CHECKOUT_SCREEN_ACTIVITY.this, MAIN_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.popular_deals:
                                startActivity(new Intent(CHECKOUT_SCREEN_ACTIVITY.this, POPULAR_DEAL_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.notifications:
                                startActivity(new Intent(CHECKOUT_SCREEN_ACTIVITY.this, WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.purchase_history:
                                startActivity(new Intent(CHECKOUT_SCREEN_ACTIVITY.this, ORDER_HISTORY_SCREEN_ACTIVITY.class));

                                return true;
                            case R.id.sign_out:
                                startActivity(new Intent(CHECKOUT_SCREEN_ACTIVITY.this, LOGIN_ACTIVITY.class));
                                return true;
                            default:
                                return false;

                        }
                    }
                });
            }

        });

    }
}
