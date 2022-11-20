package application;

import ObjectList.AssetsList;
import ObjectList.BorrowInfoList;
import ObjectList.BorrowRequestList;
import ObjectList.PeopleList;
import action_service.Inputs;
import action_service.Inputs;
import buisiness_objects.Manager;
import data_objects.Menu;
import java.io.IOException;

/**
 *
 *
 * @author Vũ Anh Lãm
 */
public class ManagerProgram {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        Manager ma = new Manager();
        
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
        menu.addItem("|3 - Create new asset               |");
        menu.addItem("|4 - Updating asset's information   |");
        menu.addItem("|5 - Approve the request of employee|");
        menu.addItem("|6 - Show list of borrow asset      |");
        menu.addItem("|7 - Quit                           |");
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
                    Assets.add(peopleList);
                    break;
                case 4:
                    Assets.update(peopleList);
                    break;
                case 5:
                    ma.approveRequest(peopleList,biList,Assets,brList);
                    break;
                case 6:
                    biList.displayBorowInfoList(peopleList);
                    break;
                case 7:
                    check = false;
                    break;
            }
        } while (check);
    }
}
