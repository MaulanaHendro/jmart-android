package com.MaulanaNurhendronotoJmartAK.jmart_android.request;

import androidx.annotation.Nullable;

import com.MaulanaNurhendronotoJmartAK.jmart_android.LoginActivity;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * CreateProductRequest Class :
 * request when user wants to create new product
 *
 * @author Maulana Nurhendronoto
 */
public class CreateProductRequest extends StringRequest
{

    public static final String URL = "http://10.0.2.2:8070/product/create";
    public final Map<String,String> params;

    /**
     * CreateProductRequest Constructor :
     * assign value to params
     *
     * @param name product name
     * @param weight product weight
     * @param conditionUsed product condition
     * @param price product price
     * @param discount product discount
     * @param category product category
     * @param shipmentPlans product shipment
     * @param listener
     * @param errorListener
     */
    public CreateProductRequest(String name, String weight, String conditionUsed, String price, String discount, String category, String shipmentPlans, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        Integer i = LoginActivity.loggedAccount.id;
        params.put("accountId", i.toString());
        params.put("name",name);
        params.put("weight",weight);
        params.put("conditionUsed",conditionUsed);
        params.put("price", price);
        params.put("discount", discount);
        params.put("category", category);
        params.put("shipmentPlans", shipmentPlans);
    }

    /**
     * getparams Method :
     *
     * @return params
     */
    public Map<String,String> getParams(){return params;}
}
