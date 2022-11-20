package ObjectList;

import action_service.Inputs;
import buisiness_objects.People;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PeopleList extends ArrayList<People> implements Serializable{
    
    public void displayPeopleList(){
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }
    
    public People findIDReturnObj(String id) {
        for (People obj : this) {
            if (obj.getEmployID().equalsIgnoreCase(id)) {
                return obj;
            }
        }
        return null;
    }

    public boolean login(String id) {
        boolean check = false;
        String password = Inputs.getString("Enter password: ", "Incorrect ID or Password");
        
        People obj = this.findIDReturnObj(id);
        if (obj == null) {
            System.out.println("Incorrect ID");
        } else if (!obj.getPassword().equalsIgnoreCase(Inputs.encryptMd5(password))) {
            System.out.println("Incorrect Password");
        } else {
            System.out.println("Successfully");
            check = true;
        }
        return check;
    }

    public boolean writeToFile() throws IOException {
        String path = "employee.dat";
        boolean result = true;
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for (People pp : this) {
                oos.writeObject(pp);
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

    public void readFromFile() {
        this.clear();
        try {
            FileInputStream fis = new FileInputStream("employee.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            People obj = null;
            while (fis.available() > 0) {
                obj = (People) ois.readObject();
                this.add(obj);
//                System.out.println(obj.toString());
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

}
