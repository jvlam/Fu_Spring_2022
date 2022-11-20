package buisiness_objects;

import ObjectList.AssetsList;
import ObjectList.BorrowInfoList;
import ObjectList.BorrowRequestList;
import ObjectList.PeopleList;
import action_service.Inputs;
import java.io.IOException;
import java.util.Date;

public class Manager extends People {

    public Manager() {
    }

    public Manager(String id) {
        super(id);
    }

    public Manager(String id, String name, Date birthdate, String role, String sex, String password) {
        super(id, name, birthdate, role, sex, password);
    }

    public void approveRequest(PeopleList checkLogin, BorrowInfoList bInfo, AssetsList aList, BorrowRequestList requestList) throws IOException {
        System.out.println("Login to use this function");
        String idLogin = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean check = checkLogin.login(idLogin);
        if (check != true) {
            System.out.println("Login Failed");
        } else {
            requestList.displayRequestList();
            if (requestList.isEmpty()) {
                System.out.println("No Data Available");
                return;
            }
            String id = Inputs.getString("Enter The ID That You Want To Aprrove: ", "Error");
            int index = requestList.findIDReturnIndex(id);
            if (index == -1) {
                System.out.println("Can not find The ID");
            } else {
                int assetIndex = aList.findIDReturnIndex(requestList.get(index).getAssetID());
                int updateQuantity = aList.get(assetIndex).getQuantity() - requestList.get(index).getQuantity();
                if (updateQuantity > 0) {
                    bInfo.add(requestList.get(index));
                    bInfo.writeToFile();
                    
                    requestList.remove(index);
                    requestList.writeToFile();
                    
                    aList.get(assetIndex).setQuantity(updateQuantity);
                    aList.writeToFile();
                    System.out.println("Approve Successfully");
                } else {
                    System.out.println("The Quantity of this stock is not enough");
                }
            }

        }
    }

}
