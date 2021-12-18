package com.MaulanaNurhendronotoJmartAK.jmart_android.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * LoginRequest Class :
 * request for login
 *
 * @author Maulana Nurhendronoto
 */
public class LoginRequest extends StringRequest{
    private static final String URL = "http://10.0.2.2:8070/account/login";
    private final Map<String, String> params;

    /**
     * LoginRequest constructor :
     * assign value to params
     *
     * @param email user email
     * @param password user password
     * @param listener
     * @param errorListener
     */
    public LoginRequest(String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

    }

    /**
     * getParams method
     * @return params
     */
    public Map<String, String> getParams()
    {
        return params;
    }

}
