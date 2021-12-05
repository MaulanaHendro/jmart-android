package com.MaulanaNurhendronotoJmartAK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.MaulanaNurhendronotoJmartAK.jmart_android.model.Account;
import com.MaulanaNurhendronotoJmartAK.jmart_android.request.LoginRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private static final Gson gson = new Gson();
    private static Account loggedAccount = null;

    public static Account getLoggedAccount()
    {
        return loggedAccount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       final EditText emailLogin= findViewById(R.id.emailLoginActivity);
       final EditText passwordLogin = findViewById(R.id.passwordLoginActivity);
       final Button  buttonLogin = findViewById(R.id.buttonLoginActivity);
       final TextView  registerLogin = findViewById(R.id.registerLoginActivity);

       registerLogin.setOnClickListener(new View.OnClickListener()
       {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public  void onClick (View v)
            {
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject!=null)
                            {
                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                loggedAccount = gson.fromJson(jsonObject.toString(),Account.class);
                                startActivity(intent);
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(emailLogin.getText().toString(), passwordLogin.getText().toString(), listener, null);
                RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                requestQueue.add(loginRequest);
            }
        });
    }
}