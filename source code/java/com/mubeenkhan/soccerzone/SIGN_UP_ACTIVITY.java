package com.mubeenkhan.soccerzone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SIGN_UP_ACTIVITY extends AppCompatActivity {
    Button signUpButton;
    EditText name,email,password,confirmPassword;
    Button login;
    private int _id = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_activity);
        name=findViewById(R.id.signUpName);
        email=findViewById(R.id.signUpEmail);
        password=findViewById(R.id.signUpPassword);
        confirmPassword=findViewById(R.id.signUpConfirmPassword);
        signUpButton=findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String user, pass, cpass,name1;
                name1=name.getText().toString().trim();
                user = email.getText().toString().trim();
                pass = password.getText().toString().trim();
                cpass = confirmPassword.getText().toString().trim();

                if (!name1.isEmpty() && !user.isEmpty() && !pass.isEmpty() && pass.equals(cpass)) {

                    final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                    // Enter the correct url for your api service site
                    String url = "http://" + ComputerIpAddress.localIP + "/smd_project/_login.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("wwww", response);
                            getID(user, requestQueue);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.v("wwww", error.toString());
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("name", name1);
                            params.put("email", user);
                            params.put("password", pass);
                            return params;
                        }
                    };
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);


                    // changing activity

                } else {
                    Toast.makeText(SIGN_UP_ACTIVITY.this,
                            "Please fill all fields correctly!",
                            Toast.LENGTH_LONG).show();
                }







    }
        });
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SIGN_UP_ACTIVITY.this,LOGIN_ACTIVITY.class));
            }
        });
    }


    private void getID(final String email, RequestQueue queue) {
        String url = "http://" + ComputerIpAddress.localIP + "/smd_project/validate_id.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        _id = findID(response, email);
                        Log.v("wwww",response);

                        Intent intent = new Intent(getApplicationContext(), MAIN_SCREEN_ACTIVITY.class);

                        Log.v("wwwwIDCP", String.valueOf(_id));
                        intent.putExtra("id", _id);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.v("wwww",error.toString());
                    }
                });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
       // queue.add(stringRequest);
    }
    private int findID(String response, String email) {
        int idx = response.indexOf(email);
        Log.v("wwwwIDX", String.valueOf(idx));
        idx = response.indexOf("ID:", idx);
        Log.v("wwwwIDX", String.valueOf(idx));

        boolean x = false;
        String id = "";
        for(int i = idx + 3; x == false && i < response.length(); ++i){
            if(response.charAt(i) != ' ')
                id += response.charAt(i);
            else
                x = true;
        }

        Log.v("wwwwID", id);
        if (!id.isEmpty())
            return Integer.parseInt(id);
        return -1;
    }


}
