package buisiness_objects;

import ObjectList.AssetsList;
import ObjectList.BorrowInfoList;
import ObjectList.BorrowRequestList;
import ObjectList.PeopleList;
import action_service.Inputs;
import java.io.IOException;

public class Employee extends People {

    public Employee() {
    }

    public Employee(String id) {
        super(id);
    }

    public void borrowAsset(PeopleList checkLogin, AssetsList aList, BorrowRequestList brList) throws IOException {
        boolean check = true;
        //login
        System.out.println("Login To Use This Function");
        String id = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean result = checkLogin.login(id);
        if (result == true) {
            do {
                aList.displayAssetsList();
                brList.add(id, aList);
                brList.writeToFile();

                String confirm = Inputs.getString("Do you want to quit(Y/N): ", "input again");
                if ("y".equalsIgnoreCase(confirm)) {
                    check = false;
                }
            } while (check);
        } else {
            System.out.println("Login Failed");
        }
    }

    public void cancleRequest(PeopleList checkLogin, BorrowRequestList brList) throws IOException {
        boolean check = true;
        //login
        System.out.println("Login To Use This Function");
        String id = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean result = checkLogin.login(id);
        if (result == true) {
            do {
                //begin cancle
                brList.displayRequestList();
                String rID = Inputs.getString("Enter ID You Want To Cancle: ", "ID error");
                int index = brList.findIDReturnIndex(rID);
                if (index == -1) {
                    System.out.println("can not find id");
                    return;
                }
                String confirm = Inputs.getString("Do you want to cancle ID: " + rID + "(Y/N) ", "ID error");
                if ("y".equalsIgnoreCase(confirm)) {
                    brList.remove(index);
                    brList.writeToFile();
                }
                String confirmQuit = Inputs.getString("Do you want to quit(Y/N): ", "input again");
                if ("y".equalsIgnoreCase(confirmQuit)) {
                    check = false;
                }
            } while (check);
        } else {
            System.out.println("Login Failed");
        }

    }

    public void returnRequest(PeopleList checkLogin, BorrowInfoList biList, AssetsList aList) throws IOException {
        boolean check = true;
        //login
        System.out.println("Login To Use This Function");
        String id = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
        boolean result = checkLogin.login(id);
        if (result == true) {
            do {
                //begin return
                biList.show();
                String idReturn = Inputs.getString("Enter borrow ID You Want To Return:", "ID error");
                int index = biList.checkID(idReturn);
                if (index == -1) {
                    System.out.println("can not find id");
                    return;
                }
                int assetIndex = aList.findIDReturnIndex(biList.get(index).getAssetID());
                int updateQuantity = biList.get(index).getQuantity() + aList.get(assetIndex).getQuantity();
                aList.get(assetIndex).setQuantity(updateQuantity);
                aList.writeToFile();

                String confirm = Inputs.getString("Do you want to Retuen ID: " + idReturn + " (Y/N) ", "ID error");
                if ("y".equalsIgnoreCase(confirm)) {
                    biList.remove(index);
                    biList.writeToFile();
                }

                String confirmQuit = Inputs.getString("Do you want to quit (Y/N): ", "input again");
                if ("y".equalsIgnoreCase(confirmQuit)) {
                    check = false;
                }
            } while (check);
        } else {
            System.out.println("Login Filed");
        }
    }
}
