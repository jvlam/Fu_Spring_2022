package buisiness_objects;

import ObjectList.AssetsList;
import action_service.Inputs;
import java.io.Serializable;
import java.util.Date;

public class BorrowRequest implements Serializable,Comparable<Object>{
    private String rID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private Date requestDateTime;
    
    public BorrowRequest() {
    }
    
    public BorrowRequest(String rID) {
        this.rID = rID;
    }

    public BorrowRequest(String rID, String assetID, String employeeID, int quantity, Date requestDateTime) {
        this.rID = rID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
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

    public Date getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }
    
    @Override
    public String toString() {
        return "[" + "rID= " + rID + ", assetID= " + assetID + ", employeeID= " + employeeID + ", quantity= " + quantity + ", requestDateTime=" + Inputs.ConvertGetDateFormAndHour(requestDateTime)+ ']';
    }
    
    public void displayRequest() {
        System.out.println("rID: " + rID + ", assetID: " + assetID + ", employeeID: " + employeeID + ", quantity: " + quantity + ", requestDateTime:" + Inputs.ConvertGetDateFormAndHour(requestDateTime));
    }

    @Override
    public boolean equals(Object obj) {
        BorrowRequest tmp = (BorrowRequest) obj;
        return this.getrID().equals(tmp.getrID());
    }

    @Override
    public int compareTo(Object o) {
        BorrowRequest other = (BorrowRequest) o;
        return this.getrID().compareTo(other.getrID());
    }
    
    public void addAsset(String employeeID, AssetsList aList, String rID){
        this.rID = rID;
        this.employeeID = employeeID;
        this.assetID = Inputs.getString("Enter Asset ID To Sent Request: ", "ID error");
        int check = aList.findIDReturnIndex(assetID);
        if(check == -1){
            System.out.println("Can not find the id");
            return;
        }
        this.quantity = Inputs.getInt("Enter quantity To Sent Request: ", "quantity error", 1, 1000);
        this.requestDateTime = new Date();
    }
    
}
