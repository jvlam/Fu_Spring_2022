package buisiness_objects;

import action_service.Inputs;
import java.io.Serializable;
import java.util.Date;

public class BorrowInfo implements Serializable {

    private String bID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private Date borrowDateTime;

    @Override
    public boolean equals(Object obj) {
        BorrowInfo other = (BorrowInfo) obj;
        return this.bID.equalsIgnoreCase(other.bID);
    }

    public BorrowInfo() {
    }

    public BorrowInfo(String bID, String assetID, String employeeID, int quantity, Date borrowDateTime) {
        this.bID = bID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDateTime = borrowDateTime;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(Date borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }

    @Override
    public String toString() {
        return "[" + "bID= " + bID + ", assetID= " + assetID + ", employeeID= " + employeeID + ", quantity= " + quantity + ", borrowDateTime= " + Inputs.ConvertGetDateFormAndHour(borrowDateTime) + ']';
    }

    public void displayBorrow() {
        System.out.printf("[" + "bID= " + bID + ", assetID= " + assetID + ", employeeID= " + employeeID + ", quantity= " + quantity + ", borrowDateTime= " + Inputs.ConvertGetDateFormAndHour(borrowDateTime) + ']'+"\n");
    }
    

}
