package ObjectList;

import action_service.Inputs;
import buisiness_objects.BorrowInfo;
import buisiness_objects.BorrowRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowInfoList extends ArrayList<BorrowInfo> implements Serializable {

    public void add(BorrowRequest brList) {
        this.add(new BorrowInfo(createID(), brList.getAssetID(), brList.getEmployeeID(), brList.getQuantity(), brList.getRequestDateTime()));
    }
    
    public String createID() {
        String id;
        for (int i = 1; i < this.size() + 2; i++) {
            id = "B00" + i;
            if (this.checkID(id) == -1) {
                return id;
            }
        }
        System.out.println("Can not create id");
        return null;
    }
    
    public int checkID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getbID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

 

    public void displayBorowInfoList(PeopleList checkLogin) throws IOException {
        System.out.println("Login To Use this function");
        String idLogin = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean check = checkLogin.login(idLogin);
        if (check != true) {
            System.out.println("Login Failed");
        } else {
            this.show();
        }
    }
    
    public void show() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println( this.get(i).toString());
        }
    }

    public boolean writeToFile() throws IOException {
        String path = "borrow.dat";
        boolean result = true;
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for (BorrowInfo bInfo : this) {
                oos.writeObject(bInfo);
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
        String path = "borrow.dat";
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            BorrowInfo bInfo = null;
            while (fis.available() > 0) {
                bInfo = (BorrowInfo) ois.readObject();
                this.add(bInfo);
//                bInfo.displayBorrow();
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
