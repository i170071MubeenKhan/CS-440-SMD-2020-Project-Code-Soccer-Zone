package com.mubeenkhan.soccerzone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

public class MAIN_SCREEN_ACTIVITY extends AppCompatActivity {
    RecyclerView rv;
    TextView add;
    MyRvListAdapter adapter;
    ArrayList<item> allEquipmentArrayList = new ArrayList<item>();
    ArrayList<item> equipmentArrayList = new ArrayList<item>();
    ArrayList<String> equipmentNames=new ArrayList<>();
    ArrayList<String> equipmentBrands=new ArrayList<>();
    static int counter = 0;
    Spinner brand,equipement;
    String brandSelected="Select Brand (no brand selected)",equipmentSelected="Select Equipment (no equipment selected)";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);
        ImageView menu=findViewById(R.id.main_screen_menu);
        brand=findViewById(R.id.main_screen_brand_spinner);
        equipement=findViewById(R.id.main_screen_equip_spinner);
        equipmentBrands.add("Select Brand (no brand selected)");
        equipmentNames.add("Select Equipment (no equipment selected)");
        getItemsFromDB();
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
                                return true;
                            case R.id.popular_deals:
                                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this, POPULAR_DEAL_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.notifications:
                                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this, WEEKLY_NOTIFICATIONS_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.purchase_history:
                                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this,ORDER_HISTORY_SCREEN_ACTIVITY.class));
                                return true;
                            case R.id.sign_out:
                                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this, LOGIN_ACTIVITY.class));
                                return true;
                            default:
                                return false;

                        }
                    }
                });
            }

        });



        rv = findViewById(R.id.main_screen_rvList);
        ImageView cart=findViewById(R.id.main_screen_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this,CHECKOUT_SCREEN_ACTIVITY.class));
            }
        });
        // add=findViewById(R.id.address);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MAIN_SCREEN_ACTIVITY.this);
        rv.setLayoutManager(manager);
        adapter = new MyRvListAdapter(MAIN_SCREEN_ACTIVITY.this, equipmentArrayList);
        rv.setAdapter(adapter);


        ArrayAdapter brandAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,equipmentBrands);
        ArrayAdapter equipAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,equipmentNames);
        brand.setAdapter(brandAdapter);
        equipement.setAdapter(equipAdapter);
        brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                brandSelected=equipmentBrands.get(i);
                equipmentArrayList.clear();
                if(equipmentSelected.equals("Select Equipment (no equipment selected)") && !brandSelected.equals("Select Brand (no brand selected)")) {//if only brand selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        if (allEquipmentArrayList.get(i1).getBrand().equals(brandSelected)) {
                            equipmentArrayList.add(allEquipmentArrayList.get(i1));
                        }
                    }

                }
                else if(brandSelected.equals("Select Brand (no brand selected)") && !equipmentSelected.equals("Select Equipment (no equipment selected)")){// only equipment selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        if (allEquipmentArrayList.get(i1).getType().equals(equipmentSelected)) {
                            equipmentArrayList.add(allEquipmentArrayList.get(i1));
                        }
                    }
                }
                else if(!brandSelected.equals("Select Brand (no brand selected)") && !equipmentSelected.equals("Select Equipment (no equipment selected)")){// both selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        if (allEquipmentArrayList.get(i1).getType().equals(equipmentSelected) && allEquipmentArrayList.get(i1).getBrand().equals(brandSelected)) {
                            equipmentArrayList.add(allEquipmentArrayList.get(i1));
                        }
                    }
                }
                else{// none selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        equipmentArrayList.add(allEquipmentArrayList.get(i1));
                    }
                    }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        equipement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                equipmentSelected=equipmentNames.get(i);
                equipmentArrayList.clear();
                if(equipmentSelected.equals("Select Equipment (no equipment selected)") && !brandSelected.equals("Select Brand (no brand selected)")) {//if only brand selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        if (allEquipmentArrayList.get(i1).getBrand().equals(brandSelected)) {
                            equipmentArrayList.add(allEquipmentArrayList.get(i1));
                        }
                    }

                }
                else if(brandSelected.equals("Select Brand (no brand selected)") && !equipmentSelected.equals("Select Equipment (no equipment selected)")){// only equipment selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        if (allEquipmentArrayList.get(i1).getType().equals(equipmentSelected)) {
                            equipmentArrayList.add(allEquipmentArrayList.get(i1));
                        }
                    }

                }
                else if(!brandSelected.equals("Select Brand (no brand selected)") && !equipmentSelected.equals("Select Equipment (no equipment selected)")){// both selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        if (allEquipmentArrayList.get(i1).getType().equals(equipmentSelected) && allEquipmentArrayList.get(i1).getBrand().equals(brandSelected)) {
                            equipmentArrayList.add(allEquipmentArrayList.get(i1));
                        }
                    }
                }
                else{// none selected
                    for (int i1 = 0; i1 < allEquipmentArrayList.size(); i1++) {
                        equipmentArrayList.add(allEquipmentArrayList.get(i1));
                    }
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

      /*

        AutoCompleteTextView auto=findViewById(R.id.search);
        auto.setThreshold(0);
        String[] names={equipmentArrayList.get(0).getName(),equipmentArrayList.get(1).getName(),equipmentArrayList.get(2).getName()};

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MAIN_SCREEN_ACTIVITY.this,android.R.layout.simple_list_item_1,names);
        auto.setAdapter(arrayAdapter);

*/
    }

  /*  public void showPopUp(View v) {
        PopupMenu pop=new PopupMenu(this,v);
        MenuInflater inflater=pop.getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu,pop.getMenu());

    }

    public void showMenu(View v){
        PopupMenu pop=new PopupMenu(this,v);
        pop.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        pop.inflate(R.menu.dropdown_menu);
    }

    public boolean onMenuItemClick(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu:
                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this,MAIN_SCREEN_ACTIVITY.class));
                return true;
            case R.id.popular_deals:
                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this,POPULAR_DEAL_SCREEN_ACTIVITY.class));
                return true;
            case R.id.notifications:
                return true;
            case R.id.purchase_history:
                return true;
            case R.id.sign_out:
                startActivity(new Intent(MAIN_SCREEN_ACTIVITY.this,LOGIN_ACTIVITY.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }*/




    private void getItemsFromDB() {
        String url = "http://" + ComputerIpAddress.localIP + "/smd_project/get_all_items.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        getItemsIntoList(response);
                        Log.v("wwww", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("wwww", error.toString());
                    }
                });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void getItemsIntoList(String response) {
        int idx1 = 0, idx2;
        String str = "";

        while (true) {
            item i = new item();

            // id
            idx2 = response.indexOf("id:", idx1);
            if (idx2 == -1)
                break;
            idx2 += "id:".length();
            idx1 = response.indexOf(" - name:", idx2);
            str = response.substring(idx2, idx1);
            i.setId(Integer.parseInt(str));


            //name
            idx2 = response.indexOf("name:", idx1);
            idx1 = response.indexOf(" - brand:", idx2);
            idx2 += "name:".length();
            str = response.substring(idx2, idx1);
            i.setName(str);


            //brand
            idx2 = response.indexOf("brand:", idx1);
            idx1 = response.indexOf(" - type:", idx2);
            idx2 += "brand:".length();
            str = response.substring(idx2, idx1);
            i.setBrand(str);


            //type
            idx2 = response.indexOf("type:", idx1);
            idx1 = response.indexOf(" - items_remaining:", idx2);
            idx2 += "type:".length();
            str = response.substring(idx2, idx1);
            i.setType(str);


            //itemsRemaining
            idx2 = response.indexOf("items_remaining:", idx1);
            idx1 = response.indexOf(" - description:", idx2);
            idx2 += "items_remaining:".length();
            str = response.substring(idx2, idx1);
            i.setItemsRemaining(Integer.parseInt(str));


            //description
            idx2 = response.indexOf("description:", idx1);
            idx1 = response.indexOf(" - original_price:", idx2);
            idx2 += "description:".length();
            str = response.substring(idx2, idx1);
            i.setDescription(str);


            //originalPrice
            idx2 = response.indexOf("original_price:", idx1);
            idx1 = response.indexOf(" - discounted_price:", idx2);
            idx2 += "original_price:".length();
            str = response.substring(idx2, idx1);
            i.setOriginalPrice(Float.parseFloat(str));


            //discounted_price
            idx2 = response.indexOf("discounted_price:", idx1);
            idx1 = response.indexOf(" - release_date:", idx2);
            idx2 += "discounted_price:".length();
            str = response.substring(idx2, idx1);
            i.setDiscountedPrice(Float.parseFloat(str));


            //release_date
            idx2 = response.indexOf("release_date:", idx1);
            idx1 = response.indexOf(" ---", idx2);
            idx2 += "release_date:".length();
            str = response.substring(idx2,idx1);
            i.setReleaseDate(str);
            Log.v("wwwwreleaseDte",str);
            if(!equipmentNames.contains(i.getType()))
                equipmentNames.add(i.getType());
            if(!equipmentBrands.contains(i.getBrand()))
                equipmentBrands.add(i.getBrand());
            equipmentArrayList.add(i);
            allEquipmentArrayList.add(i);
        }

    }
}