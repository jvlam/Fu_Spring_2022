package application;

import ObjectList.AssetsList;
import ObjectList.BorrowInfoList;
import ObjectList.BorrowRequestList;
import ObjectList.PeopleList;
import action_service.Inputs;
import buisiness_objects.Employee;
import buisiness_objects.Manager;
import data_objects.Menu;
import java.io.IOException;

public class EmployeeProgram {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        Manager ma = new Manager();
        Employee em = new Employee();
        
        AssetsList Assets = new AssetsList();
        PeopleList peopleList = new PeopleList();
        BorrowRequestList brList = new BorrowRequestList();
        BorrowInfoList biList = new BorrowInfoList();

        Assets.readFromFile();
        peopleList.readFromFile();
        brList.readFromFile();
        biList.readFromFile();

        menu.addItem("|===================================|");
        menu.addItem("|1 - Login                          |");
        menu.addItem("|2 - Search Asset  By Name          |");
        menu.addItem("|3 - Borrow The Assets              |");
        menu.addItem("|4 - Cancle Request                 |");
        menu.addItem("|5 - Return request                 |");
        menu.addItem("|6 - Quits Program                  |");
        menu.addItem("|===================================|");
        boolean check = true;
        do {    
            menu.showMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    String idLogin = Inputs.getString("Enter ID: ", "Incorrect ID or Password");
                    peopleList.login(idLogin);
                    break;
                case 2:
                    Assets.search();
                    break;
                case 3:
                    em.borrowAsset(peopleList, Assets, brList);
                    break;
                case 4:
                    em.cancleRequest(peopleList, brList);
                    break;
                case 5:
                    em.returnRequest(peopleList, biList, Assets);
                    break;
                case 6:
                    check = false;
                    break;
            }
        } while (check);
    }
}
