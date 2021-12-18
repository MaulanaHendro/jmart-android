package com.MaulanaNurhendronotoJmartAK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ProductDetailActivity :
 * display product detail when product is tapped
 *
 * @author Maulana Nurhendronoto
 */
public class ProductDetailActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView productName = (TextView) findViewById(R.id.productName_productDetail);
        TextView productPrice = (TextView) findViewById(R.id.productPrice_productDetail);
        TextView productCategory = (TextView) findViewById(R.id.category);
        TextView productCondition = (TextView) findViewById(R.id.condition);
        TextView productWeight = (TextView) findViewById(R.id.weight);
        TextView productShipment = (TextView) findViewById(R.id.shipmentplan);
        Button buyButton = (Button) findViewById(R.id.buyButton_productDetail);

        productName.setText(ProductFragment.productClicked.name);

        String translatedCondition = "";
        if(ProductFragment.productClicked.conditionUsed)
        {
            translatedCondition = "New";
        }
        else
        {
            translatedCondition = "Used";
        }

        productPrice.setText("Rp. " + String.valueOf(ProductFragment.productClicked.price));
        productCategory.setText(String.valueOf(ProductFragment.productClicked.category));
        productCondition.setText(translatedCondition);
        productWeight.setText(String.valueOf(ProductFragment.productClicked.weight));

        int shipmentPlansValue = ProductFragment.productClicked.shipmentPlans;
        switch (shipmentPlansValue)
        {
            case 0:
                productShipment.setText("INSTANT");
                break;
            case 1:
                productShipment.setText("SAME DAY");
                break;
            case 2:
                productShipment.setText("NEXT DAY");
                break;
            case 3:
                productShipment.setText("REGULER");
                break;
            case 4:
                productShipment.setText("KARGO");
                break;
            default:
                productShipment.setText("UNKNOWN");
        }

        buyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(ProductDetailActivity.this, "BUY", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProductDetailActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

}