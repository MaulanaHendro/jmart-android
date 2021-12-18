package com.MaulanaNurhendronotoJmartAK.jmart_android.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * PaymentRequest Class :
 * request for payment
 *
 * @author Maulana Nurhendronoto
 */
public class PaymentRequest extends StringRequest {
    private static final String URL = "http://10.0.2.2:8070/payment/create";
    private final Map<String , String> params;

    /**
     * PaymentRequest Constructor :
     * assign value to params
     *
     * @param buyerId buyer id
     * @param productId product id
     * @param productCount product amount
     * @param shipmentAddress address for shipping
     * @param shipmentPlan type of shipment
     * @param listener
     * @param errorListener
     */
    public PaymentRequest(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan, Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("buyerId", Integer.toString(buyerId));
        params.put("productId", Integer.toString(productId));
        params.put("productCount", Integer.toString(productCount));
        params.put("shipmentAddress", shipmentAddress);
        params.put("shipmentPlan", Byte.toString(shipmentPlan));
    }

    /**
     * getParams method
     *
     * @return params
     */
    public Map<String, String> getParams(){return params;}
}
