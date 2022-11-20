package ObjectList;

import buisiness_objects.BorrowRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowRequestList extends ArrayList<BorrowRequest> implements Serializable {

    public String createID() {
        String id;
        for (int i = 1; i < this.size() + 2; i++) {
            id = "R00" + i;
            if (this.findIDReturnIndex(id) == -1) {
                return id;
            }
        }
        return null;
    }

    public void add(String employeeID,AssetsList aList) {
        BorrowRequest borrow = new BorrowRequest();
        borrow.addAsset(employeeID, aList, this.createID());
        this.add(borrow);
        System.out.println("Borrow Successfull");
    }

    public boolean writeToFile() throws IOException {
        String path = "request.dat";
        boolean result = true;
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for (BorrowRequest req : this) {
                oos.writeObject(req);
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
    
    
    public int findIDReturnIndex(String id) {
        if (this.isEmpty()) {
            System.out.println("The List is Empty");
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getrID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public void readFromFile() throws FileNotFoundException, IOException {
        this.clear();
        String path = "request.dat";
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            BorrowRequest req = null;
            while (fis.available() > 0) {
                req = (BorrowRequest) ois.readObject();
                this.add(req);
//                req.displayRequest();
            }
        } catch (NumberFormatException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssetsList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fis.close();
            ois.close();
        }
    }

    public void displayRequestList() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

}
