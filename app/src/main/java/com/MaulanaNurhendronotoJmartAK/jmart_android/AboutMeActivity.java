package com.MaulanaNurhendronotoJmartAK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.MaulanaNurhendronotoJmartAK.jmart_android.model.Store;
import com.MaulanaNurhendronotoJmartAK.jmart_android.request.RegisterStoreRequest;
import com.MaulanaNurhendronotoJmartAK.jmart_android.request.TopUpRequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * AboutMeActivity Class
 * display user information, i.e. name, email, and balance
 *
 * @author Maulana Nurhendronoto
 */
public class AboutMeActivity extends AppCompatActivity {
    private static final Gson gson = new Gson();
    private static Store storeAccount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        TextView name = (TextView) findViewById(R.id.name_aboutMeActivity);
        name.setText("" + LoginActivity.getLoggedAccount().name);

        TextView email = (TextView) findViewById(R.id.address_aboutMeActivity);
        email.setText("" + LoginActivity.getLoggedAccount().email);

        TextView balance = (TextView) findViewById(R.id.balance_aboutMeActivity);
        balance.setText("" + LoginActivity.getLoggedAccount().balance);

        TextInputLayout topUp = (TextInputLayout) findViewById(R.id.topup_layout);
        Button topUpButton = (Button) findViewById(R.id.button_topup);

        CardView registerCardView = (CardView) findViewById(R.id.register_cardview);

        TextInputLayout storeTextLayout = (TextInputLayout) findViewById(R.id.store_textlayout);
        TextInputLayout addressTextLayout = (TextInputLayout) findViewById(R.id.address_textlayout);
        TextInputLayout phoneTextLayout = (TextInputLayout) findViewById(R.id.phone_textlayout);

        TextView store = (TextView) findViewById(R.id.store_name);
        TextView address = (TextView) findViewById(R.id.store_address);
        TextView phone = (TextView) findViewById(R.id.store_phone);

        Button newStoreButton  = findViewById(R.id.button_register);
        Button registerStoreButton = (Button) findViewById(R.id.button_register_store);
        Button cancelStoreButton = (Button) findViewById(R.id.button_cancel_store);

        ConstraintLayout registration = findViewById(R.id.register_constraint);
        ConstraintLayout storeDetail = findViewById(R.id.store_constraint);

        if(LoginActivity.getLoggedAccount().store != null)
        {
            newStoreButton.setVisibility(newStoreButton.INVISIBLE);
            store.setText(LoginActivity.getLoggedAccount().store.name);
            address.setText(LoginActivity.getLoggedAccount().store.address);
            phone.setText(LoginActivity.getLoggedAccount().store.phoneNumber);
            storeDetail.setVisibility(storeDetail.VISIBLE);
        }
        else
        {
            newStoreButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    newStoreButton.setVisibility(view.INVISIBLE);
                    registration.setVisibility(view.VISIBLE);
                    cancelStoreButton.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            newStoreButton.setVisibility(v.VISIBLE);
                            registration.setVisibility(v.INVISIBLE);

                        }
                    });
                }
            });
        }
        registerStoreButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Response.Listener<String> listener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject object = new JSONObject(response);
                            Toast.makeText(AboutMeActivity.this, "Store created.", Toast.LENGTH_SHORT).show();
                            LoginActivity.loggedAccount.store = gson.fromJson(object.toString(), (Type) Store.class);
                            System.out.println("Creating store");
                            System.out.println(LoginActivity.loggedAccount.store);
                            finish();
                            startActivity(getIntent());
                        }
                        catch (JSONException e)
                        {
                            Toast.makeText(AboutMeActivity.this, "Creating store failed.", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                };
                RegisterStoreRequest registerStoreRequest = new RegisterStoreRequest(LoginActivity.getLoggedAccount().id,  storeTextLayout.getEditText().getText().toString(), addressTextLayout.getEditText().getText().toString(), phoneTextLayout.getEditText().getText().toString(), listener, null);
                RequestQueue requestQueue = Volley.newRequestQueue(AboutMeActivity.this);
                requestQueue.add(registerStoreRequest);
            }
        });
        topUp.getEditText().setText("0");

        topUpButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Response.Listener<String> listener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        if(Boolean.parseBoolean(response))
                        {
                            Toast.makeText(AboutMeActivity.this, "Top up success", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(AboutMeActivity.this, "Top up fail", Toast.LENGTH_SHORT).show();
                        }
                        LoginActivity.loggedAccount.balance += Double.parseDouble(topUp.getEditText().getText().toString());
                        finish();
                        startActivity(getIntent());
                    }
                };
                TopUpRequest topUpRequest = new TopUpRequest(LoginActivity.getLoggedAccount().id, Double.parseDouble(topUp.getEditText().getText().toString()), listener, null);
                RequestQueue requestQueue = Volley.newRequestQueue(AboutMeActivity.this);
                requestQueue.add(topUpRequest);
            }
        });
    }

}