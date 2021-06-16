package com.mubeenkhan.soccerzone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LOGIN_ACTIVITY extends AppCompatActivity {
    private int _id = -1;
    Button loginButton;
    Button createAccount;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        username=findViewById(R.id.login_username);
        password=findViewById(R.id.login_password);
        loginButton=findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String email = username.getText().toString().trim();
                final String pass = password.getText().toString().trim();

                final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://" + ComputerIpAddress.localIP + "/smd_project/validate_user.php";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                _id = validate_user(response, email, pass);
                                Log.v("wwww", response);

                                if (_id != -1) {
                                    Log.v("wwwwIDCP", String.valueOf(_id));

                                    Intent intent = new Intent(getApplicationContext(), MAIN_SCREEN_ACTIVITY.class);
                                    intent.putExtra("id", _id);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LOGIN_ACTIVITY.this, "Email or password incorrect!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.v("wwww", "http://" + ComputerIpAddress.localIP + "/chat_app_a3/validate_user.php"+error.toString());
                            }
                        });

                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
       }
        });
        createAccount=findViewById(R.id.createAccount);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LOGIN_ACTIVITY.this,SIGN_UP_ACTIVITY.class));
            }
        });
    }

    private int validate_user(String response, String email, String password) {
        int idx = response.indexOf(email);
        if (idx == -1)
            return -1;

        idx = response.indexOf("password:", idx);
        idx += 9;

        boolean x = false;
        String temp = "";
        for (int i = idx; x == false && i < response.length(); ++i) {
            if (response.charAt(i) != '|')
                temp += response.charAt(i);
            else
                x = true;
        }
        if (!password.equals(temp))
            return -1;

        idx = response.indexOf("ID:", idx);

        x = false;
        temp = "";
        for (int i = idx + 3; x == false && i < response.length(); ++i) {
            if (response.charAt(i) != '_')
                temp += response.charAt(i);
            else
                x = true;
        }

        if (!temp.isEmpty())
            return Integer.parseInt(temp);

        return -1;
    }
}
