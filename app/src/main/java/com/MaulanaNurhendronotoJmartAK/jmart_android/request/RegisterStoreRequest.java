package com.MaulanaNurhendronotoJmartAK.jmart_android.request;

import com.MaulanaNurhendronotoJmartAK.jmart_android.LoginActivity;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * RegisterStoreRequestClass :
 * request for registering store
 *
 * @author Maulana Nurhendronoto
 */
public class RegisterStoreRequest extends StringRequest {
    private static final String URL =  "http://10.0.2.2:8070/account/" + LoginActivity.getLoggedAccount().id + "/registerStore";
    private final Map<String , String> params;

    /**
     * RegisterStoreRequest constructor
     * assign value to params
     *
     * @param id user id
     * @param name store name
     * @param address store address
     * @param phoneNumber store phone number
     * @param listener
     * @param errorListener
     */
    public RegisterStoreRequest(int id, String name, String address, String phoneNumber, Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
        Integer  i = id;
        params = new HashMap<>();
        params.put("id", i.toString());
        params.put("name", name);
        params.put("address", address);
        params.put("phoneNumber", phoneNumber);
    }

    /**
     * getParams method
     *
     * @return params
     */
    public Map<String , String> getParams() {
        return params;
    }

}
