package buisiness_objects;

import java.io.Serializable;

public class Assets implements Comparable<Assets>, Serializable {

    private String assetID;
    private String name;
    private String color;
    private int price;
    private double weight;
    private int quantity;
    
    @Override
    public int compareTo(Assets o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
    
    public Assets(String assetID) {
        this.assetID = assetID;
    }

    public Assets(String assetID, int quantity) {
        this.assetID = assetID;
        this.quantity = quantity;
    }

    public Assets() {
    }

    public Assets(String assetID, String name, String color, int price, double weight, int quantity) {
        this.assetID = assetID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
         return "[" + "assetID= " + assetID + ", name= " + name + ", color= " + color + ", price= " + price + ", weight= " + weight + ", quantity= " + quantity + ']';
    }

    public void displayAssets() {
        System.out.printf("|AssetsID: %s|Name: %s|Color: %s|Price: %d|Weight: %2.1f|Quantity: %d|\n",
                this.getAssetID(), this.getName(), this.getColor(), this.getPrice(), this.getWeight(), this.getQuantity());
    }

}
