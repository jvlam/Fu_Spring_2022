package business_objects;

import acction_service.Inputs;

public class Car extends Vehicle {
    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String id, String name, String color, int price, String brand, String type, int yearOfManufacture) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public void update() {
        super.update();
        this.type = Inputs.getStringUpdate("Update new Type Car: ", type);
        this.yearOfManufacture = Inputs.getIntUpdate("Update new year of Manufacture: ", "⚠ Update year again ⚠", 1900, 2022, yearOfManufacture);
    }

    @Override
    public void create() {
        super.create();
        this.type = Inputs.getString("Enter Type of the Car: ", "⚠ Input type Again ⚠");
        this.yearOfManufacture = Inputs.getInt("Enter year of manufacture[1900-2022]: ", "⚠ Year Manufacture just from [1900-2022] ⚠️", 1900, 2022);
    }

    @Override
    public String toString() {
        return this.getId()+":"+this.getName()+":"+this.getColor()+":"+this.getPrice()+":"+this.getBrand()+":"+this.type+":"+this.yearOfManufacture;
    }
    
    
    @Override
    public void printList() {
        System.out.printf("|ID: %5s|Name: %6s|Color: %5s|Price: %10d|Brand: %6s|Type: %4s|Year of Manufacture: %4s|\n",
                getId(), getName(), getColor(), getPrice(), getBrand(), getType(), getYearOfManufacture());
    }

}
