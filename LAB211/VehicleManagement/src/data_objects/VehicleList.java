package data_objects;

import business_objects.Motorbike;
import business_objects.Car;
import business_objects.Vehicle;
import acction_service.Inputs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VehicleList extends ArrayList<Vehicle> implements I_List {

    public int vehicleType() {
        int choice;
        Menu subMenu = new Menu();
        System.out.println("- Enter Vehical Type -");
        subMenu.addItem("1 - Motorbike");
        subMenu.addItem("2 - Car");
        subMenu.showMenu();
        choice = Inputs.getInt("Enter Your Choice [1 to " + subMenu.size() + "]: ", "⚠ Enter [1 to " + subMenu.size() + "] Please ⚠", 1, subMenu.size());
        return choice;
    }

    public Vehicle findIDReturnObj(String id) {
        if (this.isEmpty()) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(id)) {
                return this.get(i);
            }
        }
        return null;
    }

    @Override
    public void add() {
        boolean check = true;
        do {
            Vehicle obj = null;
            int type = vehicleType();
            String id;

            do {
                id = Inputs.getString("Enter your ID: ", "Enter ID Again");
                obj = this.findIDReturnObj(id);
                if (obj == null) {
                    check = false;
                } else {
                    System.out.println("ID Duplicated");
                    check = true;
                }
            } while (check);

            switch (type) {
                case 1:
                    obj = new Motorbike();
                    obj.create();
                    break;
                case 2:
                    obj = new Car();
                    obj.create();
                    break;
            }
            obj.setId(id);
            this.add(obj);
            System.out.println("✅ Add Successfully");

            check = Inputs.confirmYesNo("Do You Want Continue To Create A New Vehicle Or Go Back Main Menu (Y/N) :", "⚠ Enter Yes or No Please ⚠");
        } while (!check);
    }

    @Override
    public void update() {
        String id = Inputs.getString("Enter ID Vehical you want to Update: ", "⚠ Input ID Again ⚠");
        Vehicle obj = this.findIDReturnObj(id);
        if (obj == null) {
            System.out.println("⚠ Vehicle Does Not Exist ⚠");
        } else {
            System.out.println("===Vehical Before Update===");
            obj.printList();
            obj.update();
            System.out.println("===Vehical After Update===");
            obj.printList();
        }
    }

    @Override
    public void delete() {
        String id = Inputs.getString("Enter ID You Want To Delete: ", "⚠ Input ID Again ⚠");
        Vehicle obj = this.findIDReturnObj(id);
        if (obj == null) {
            System.out.println("⚠ Vehicle Does Not Exist ⚠");
        } else {
            boolean confirm = Inputs.confirmYesNo("Are You Sure That You Want To Delete The ID " + id + " (Y/N): ", "⚠ Enter Yes or No Please ⚠");
            if (confirm == false) {
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i).getId().equalsIgnoreCase(id)) {
                        this.remove(i);
                    }
                }
                System.out.println("✅ Delete Successfully");
            } else {
                System.out.println("⚠ Fail To Delete ⚠");
            }
        }
    }

    @Override
    public void search() {
        Menu subMenu = new Menu();
        subMenu.addItem("1 - Search By Name");
        subMenu.addItem("2 - Search By ID");
        subMenu.addItem("3 - Search By speed");
        subMenu.showMenu();
        int type = Inputs.getInt("Enter your choice [1 or " + subMenu.size() + " ]: ", "⚠ Enter Again ⚠", 1, subMenu.size());

        switch (type) {
            case 1:
                String name = Inputs.getString("Enter Vehicle's Name You Want To Search: ", "⚠ Enter Name Again  ⚠ ");
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                        this.get(i).printList();
                    }
                }
                break;
            case 2:
                String id = Inputs.getString("Enter ID You Want To Search: ", " ⚠ Enter ID Again ⚠");
                Vehicle vehicle = this.findIDReturnObj(id);
                if (vehicle == null) {
                    System.out.println("⚠ Can Not Find The ID ⚠");
                } else {
                    vehicle.printList();
                }
                break;
            case 3:
                int speed = Inputs.getInt("Enter speed: ", "err", 1, 400);
                Vehicle mt = new Motorbike();
                Motorbike  x = (Motorbike)mt;
                this.loadFromFile();
                for (int i = 0; i < this.size(); i++) {
                    x.getSpeed();
                    
                }
                break;
        }
    }

    @Override
    public void show() {
        Menu subMenu = new Menu();
        System.out.println("Select Menu Here: ");
        subMenu.addItem("1 - Show All Vehicle In The List");
        subMenu.addItem("2 - Show All Vehicle Descending By Price");
        subMenu.showMenu();
        int choice = Inputs.getInt("Enter Your Choice [1 to " + subMenu.size() + "]: ", "⚠ Enter [1 to " + subMenu.size() + "] Please ⚠", 1, subMenu.size());
        switch (choice) {
            case 1:
                System.out.println("All information of Vehicle");
                System.out.println("------------------------------------------------------------------------------------------------------------");
                this.showList();
                System.out.println("------------------------------------------------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("Descending By PRICE");
                System.out.println("------------------------------------------------------------------------------------------------------------");
                Comparator compareToPrice = new Comparator<Vehicle>() {
                    @Override
                    public int compare(Vehicle v1, Vehicle v2) {
                        return v1.getPrice() - v2.getPrice();
                    }
                };
                Collections.sort(this, compareToPrice);
                Collections.reverse(this);
                for (Vehicle obj : this) {
                    obj.printList();
                    if (obj instanceof Motorbike) {
                        ((Motorbike) obj).makeSound();
                    }
                }
                System.out.println("------------------------------------------------------------------------------------------------------------");
                break;
        }
    }

    public void showList() {
        for (Vehicle obj : this) {
            obj.printList();
        }
    }

    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter("VehicleData.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Vehicle obj : this) {
                bw.write(obj.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }

    }

    public void loadFromFile() {
        this.clear();
        try {
            FileReader fr = new FileReader("VehicleData.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] tmp = line.split(":");
                String id = tmp[0];
                String name = tmp[1];
                String color = tmp[2];
                int price = Integer.parseInt(tmp[3]);
                String brand = tmp[4];

                if (brand.equalsIgnoreCase("Car")) {
                    String type = tmp[5];
                    int yearOfManufacture = Integer.parseInt(tmp[6]);
                    this.add(new Car(id, name, color, price, brand, type, yearOfManufacture));
                } else if (brand.equalsIgnoreCase("Moto")) {
                    int speed = Integer.parseInt(tmp[5]);
                    String license = tmp[6];
                    this.add(new Motorbike(id, name, color, price, brand, speed, license));
                }
            }
        } catch (Exception e) {
        }
    }

}
