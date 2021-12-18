package com.MaulanaNurhendronotoJmartAK.jmart_android.model;

/**
 * Product class :
 * return value of name and price
 *
 * @author Maulana Nurhendronoto
 */
public class Product extends Serializable{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

    public String toString()
    {
        String name = "Name: " + this.name + "\n";
        String weight = "Weight: " + this.weight + "\n";
        String conditionUsed = "conditionUsed: " + this.conditionUsed + "\n";
        String category = "category: " + this.category + "\n";
        String accountId = "accountid: " + this.accountId + "\n";
        String price = "price: " + this.price + "\n";
        String discount = "discount: " + this.discount + "\n";
        String shipmentPlans = "shipmentPlans: " + this.shipmentPlans + "\n";

        return name+price;
    }
}
