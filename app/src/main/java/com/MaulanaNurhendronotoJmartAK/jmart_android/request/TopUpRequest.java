package com.MaulanaNurhendronotoJmartAK.jmart_android.request;

import androidx.annotation.Nullable;

import com.MaulanaNurhendronotoJmartAK.jmart_android.LoginActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * TopUpRequest Class :
 * request for topping up balance
 *
 * @author Maulana Nurhendronoto
 */
public class TopUpRequest extends StringRequest {
    private static final String URL =  "http://10.0.2.2:8070/account/" + LoginActivity.getLoggedAccount().id + "/topUp";
    private final Map<String , String> params;

    /**
     * TopUpRequest constructor
     * assign value to params
     *
     * @param id user identity
     * @param balance user balance
     * @param listener
     * @param errorListener
     */
    public TopUpRequest
    (
            int id,
            double balance,
            Response.Listener<String> listener,
            Response.ErrorListener errorListener
    )
    {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("id", Integer.toString(id));
        params.put("balance", Double.toString(balance));
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
