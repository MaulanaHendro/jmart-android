package com.MaulanaNurhendronotoJmartAK.jmart_android.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * RegisterRequest Class :
 * request for register
 *
 * @author Maulana Nurhendronoto
 */
public class RegisterRequest extends StringRequest {
    private static final String URL = "http://10.0.2.2:8070/account/register";
    private final Map<String, String> params;

    /**
     * RegisterRequest constructor
     * assign value to params
     *
     * @param name user name
     * @param email user email
     * @param password user password
     * @param listener
     * @param errorListener
     */
    public RegisterRequest(String name, String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
    }

    /**
     * getParams method
     *
     * @return
     */
    public Map<String, String> getParams()
    {
        return params;
    }
}
