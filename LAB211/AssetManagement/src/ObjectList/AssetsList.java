package ObjectList;

import action_service.Inputs;
import buisiness_objects.Assets;
import data_objects.I_List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssetsList extends ArrayList<Assets> implements I_List, Serializable {

    public int findIDReturnIndex(String id) {
        if (this.isEmpty()) {
            System.out.println("The List is Empty");
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getAssetID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Assets findIDReturnObj(String id) {
        for (Assets obj : this) {
            if (obj.getAssetID().equalsIgnoreCase(id)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public void add(PeopleList checkLogin) throws IOException {
        //login
        System.out.println("Login to use this function");
        String idLogin = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean check = checkLogin.login(idLogin);
        //add
        if (check == false) {
            System.out.println("login Failed");
        } else {
            boolean result = false;
            do {
                String id;
                boolean tmp = true;
                do {
                    id = Inputs.getString("Enter Asset ID: ", "Error ID");
                    Assets obj = this.findIDReturnObj(id);
                    if (obj == null) {
                        tmp = false;
                    } else {
                        System.out.println("ID Duplicated");
                        tmp = true;
                    }
                } while (tmp);

                String name = Inputs.getString("Enter Asset's Name: ", "Enter name again");
                String color = Inputs.getString("Enter Assets'color: ", "Enter color again");
                int price = Inputs.getInt("Enter Assets's Price: ", "Enter price again", 1, 1000);
                double weight = Inputs.getDouble("Enter Asset's Weight: ", "Enter weight again", 0, 100);
                int quantity = Inputs.getInt("Enter Asset's Quantity: ", "Enter quantity again", 1, 100);
                this.add(new Assets(id, name, color, price, weight, quantity));
                this.writeToFile();
                String confirm = Inputs.getString("Do you want to create a new asset? {Y/N} : ", "Error");
                if ("y".equalsIgnoreCase(confirm)) {
                    result = true;
                } else {
                    result = false;
                }
            } while (result);
        }
    }

    @Override
    public void update(PeopleList checkLogin) {
        //login
        System.out.println("Login to use this function");
        String idLogin = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean check = checkLogin.login(idLogin);
        //Update
        if (check == false) {
            System.out.println("login Failed");
        } else {
            String id = Inputs.getString("Enter Asset's ID You Want To Update: ", "Enter ID again");
            Assets obj = this.findIDReturnObj(id);

            if (obj == null) {
                System.out.println("Asset does not exist");
            } else {
                System.out.println("Before Update");
                obj.displayAssets();
                String name = Inputs.getStringUpdate("Update new Asset's Name: ", obj.getName());
                obj.setName(name);

                String color = Inputs.getStringUpdate("Update new Asset's Color: ", obj.getColor());
                obj.setColor(color);

                int price = Inputs.getIntUpdate("Update new Asset's Price:", "Enter price again", 1, 1000, obj.getPrice());
                obj.setPrice(price);

                double weight = Inputs.getDoubleUpdate("Update new Asset's weight: ", "Enter weight again", 1, 1000, obj.getWeight());
                obj.setWeight(weight);

                int quantity = Inputs.getIntUpdate("Update new Asset's Quantity: ", "Enter quantity again", 1, 100, obj.getQuantity());
                obj.setQuantity(quantity);
                System.out.println("After Update");
                obj.displayAssets();
            }
        }
    }

    @Override
    public void search() {
        String name = Inputs.getString("Enter name you want to search: ", "Name error");
        Collections.sort(this);
        for (int i = 0; i < this.size(); i++) {
            if ((this.get(i).getName().toLowerCase()).contains(name.toLowerCase())) {
                System.out.println(this.get(i).toString() + "subtotal :" + this.get(i).getPrice() * this.get(i).getQuantity());
            }
        }
    }

    public void displayAssetsList() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

    public boolean writeToFile() throws IOException {
        String path = "asset.dat";
        boolean result = true;
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for (Assets as : this) {
                oos.writeObject(as);
            }
        } catch (Exception e) {
            result = false;
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
        return result;
    }

    public void readFromFile() throws FileNotFoundException, IOException {
        this.clear();
        String path = "asset.dat";
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Assets as = null;
            while (fis.available() > 0) {
                as = (Assets) ois.readObject();
                this.add(as);
//                this.displayAssetsList();
            }
        } catch (NumberFormatException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssetsList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fis.close();
            ois.close();
        }
    }

}
