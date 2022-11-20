
package business_objects;

import acction_service.Inputs;


public class Motorbike extends Vehicle{
    
    private int speed;
    private String license;

    public Motorbike() {
    }

    public Motorbike(String id, String name, String color, int price, String brand,int speed, String lisence) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = lisence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public void update() {
        super.update(); 
        speed = Inputs.getIntUpdate("update new speed:", "enter speed again", 1, 300, speed);
        license = Inputs.getStringUpdate("Update Your Lisence: ", license);
    }

    @Override
    public void create() {
        super.create();
        speed = Inputs.getInt("Enter Your Motorbike Speed [0km/h to 300km/h]: ", "⚠ Speed Of A Motorbike Just from [0km/h to 300km/h] ⚠", 0, 300);
        license = Inputs.getString("Enter Your Lisence Require: ", "⚠ Yes or No ⚠");
    }
    
    public void makeSound(){
        System.out.println("Tin tin tin");
    }

    @Override
    public String toString() {
        return this.getId()+":"+this.getName()+":"+this.getColor()+":"+this.getPrice()+":"+this.getBrand()+":"+ this.getSpeed()+":"+this.getLicense();
    }

    @Override
    public void printList() {
        System.out.printf("|ID: %5s|Name: %6s|Color: %5s|Price: %10d|Brand: %6s|speed: %4d|License: %3s|\n",
                         getId(), getName(), getColor(), getPrice(), getBrand(), getSpeed(), getLicense());
    }

    

    

}
