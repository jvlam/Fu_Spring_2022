package business_objects;

import acction_service.Inputs;
import java.util.Comparator;

public abstract class Vehicle implements Comparable<Vehicle>{

    protected String id;
    protected String name;
    protected String color;
    protected int price;
    protected String brand;

    public Vehicle() {
    }

    public Vehicle(String id) {
        this.id = id;
    }
    
    public Vehicle(String id, String name, String color, int price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void create() {
        this.name = Inputs.getString("Enter Name of vehicle: ", "⚠ Enter Name Again ⚠");
        this.color = Inputs.getString("Enter Color of vehicle: ", "⚠ Enter Color Again ⚠");
        this.price = Inputs.getInt("Enter Price of vehicle: ", "⚠ Enter Price Again ⚠", 0, 1000000000);
        this.brand = Inputs.getString("Enter Brand of vehicle: ", "⚠ Enter Color Again ⚠");
    }

    public void update() {
        this.name = Inputs.getStringUpdate("Update new Name of vehicle: ", name);
        this.color = Inputs.getStringUpdate("Update new Color: ", id);
        this.price = Inputs.getIntUpdate("Update new Price of vehicle:", "⚠ Enter Price Again ⚠", 1, 1000000000, price);
        this.brand = Inputs.getStringUpdate("Update new Brand of vehicle: ", brand);
    }

    public abstract void printList();
    
    @Override
    public int compareTo(Vehicle o) {
        return o.price - this.price;
    }
    
}
