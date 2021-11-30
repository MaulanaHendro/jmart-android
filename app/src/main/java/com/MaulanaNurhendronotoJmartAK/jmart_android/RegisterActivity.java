package com.MaulanaNurhendronotoJmartAK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;

import com.MaulanaNurhendronotoJmartAK.jmart_android.model.Account;
import com.MaulanaNurhendronotoJmartAK.jmart_android.request.RegisterRequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private static final Gson gson = new Gson();
    private static Account loggedAccount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       final EditText nameregister = findViewById(R.id.nameRegisterActivity);
       final EditText emailregister = findViewById(R.id.emailRegisterActivity);
       final EditText passwordregister = findViewById(R.id.passwordRegisterActivity);
       final Button  registerbutton = findViewById(R.id.buttonRegisterActivity);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject!=null)
                            {
                                Toast.makeText(RegisterActivity.this, "Registration success", Toast.LENGTH_SHORT);
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                loggedAccount = gson.fromJson(jsonObject.toString(),Account.class);
                                startActivity(intent);
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this, "registration failed", Toast.LENGTH_SHORT);
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(nameregister.getText().toString(), emailregister.getText().toString(), passwordregister.getText().toString(), listener, null);
                RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(registerRequest);
            }
        });
    }
}