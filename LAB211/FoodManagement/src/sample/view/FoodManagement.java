package sample.view;

import sample.controllesrs.FoodList;
import sample.controllesrs.Menufuction;
//import sample.dto.Food;
import sample.dto.I_List;
//import sample.dto.I_Menu;
import sample.utils.Input;

public class FoodManagement {

    public static void main(String[] args) {
//        I_List food = new FoodList();
//        I_Menu menu = new Menufuction();
        FoodList food = new FoodList();
        Menufuction menu = new Menufuction();
        menu.addItem("============================");
        menu.addItem("|1 - Add A New Food        |");
        menu.addItem("|2 - Search A Food By Name |");
        menu.addItem("|3 - Remove Food By Id     |");
        menu.addItem("|4 - Print The Food        |");
        menu.addItem("|5 - Exit                  |");
        menu.addItem("============================");
        boolean check = true;
        boolean result;
        do {
            menu.showMenu(); // ??????????????/
            System.out.println("The total Food now is: " +food.numberOfFood());
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        food.add(); //chấm sẽ chạy của con vì đã được thừa hưởng các hàm của Cha @override
                        result = Input.confirmYesNo("Y/N: ");
                    } while (result);
                    break;
                case 2:
                    do {
                        food.searchByname();
                        String confirm = Input.getString("Do you want to searching another food or return to the menu (Y/N): ", "Input Y or N️");
                        result = "Y".equalsIgnoreCase(confirm);
                    } while (result);
                    break;
                case 3:
                    food.removeByID();
                    break;
                case 4:
                    food.printListDescendingByExpiredDate();
                    break;
                case 5:
                    String confirm = Input.getString("Do You Want To Quit? (Y/N): ", "Input Y or N only");
                    if ("Y".equalsIgnoreCase(confirm)) {
                        check = false;
                    }
                    break;
            }
        } while (check);
    }
}
