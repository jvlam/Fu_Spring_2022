package application;

import data_objects.Menu;
import data_objects.VehicleList;
public class ShowRoomManagement {

    public static void main(String args[]) {
        VehicleList transport = new VehicleList();
        transport.loadFromFile();
        Menu menu = new Menu();
        menu.addItem("===============================");
        menu.addItem("|1 - Load Data From File      |");
        menu.addItem("|2 - Add A New Vehicle        |");
        menu.addItem("|3 - Update vehical by ID     |");
        menu.addItem("|4 - Delete vehical by ID     |");
        menu.addItem("|5 - Search vehical           |");
        menu.addItem("|6 - Show vehicle list        |");
        menu.addItem("|7 - Store Data To File       |");
        menu.addItem("|8 - Quit                     |");
        menu.addItem("===============================");
        int choice;
        boolean check = true;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    transport.loadFromFile();
                    break;
                case 2:
                    transport.add();
                    break;
                case 3:
                    transport.update();
                    break;
                case 4:
                    transport.delete();
                    break;
                case 5:
                    transport.search();
                    break;
                case 6:
                    transport.show();
                    break;
                case 7:
                    transport.writeToFile();
                    break;
                case 8:
                    check = false;
                    break;
            }
        } while (check);
    }
}
