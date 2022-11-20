package data_objects;


import action_service.Inputs;
//import data_objects.I_Menu;
import java.util.ArrayList;

public class Menu extends ArrayList<String> implements I_Menu {

    @Override
    public void addItem(String item) {
        this.add(item);
    }

    @Override
    public void showMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }

    @Override
    public int getChoice() {
        return Inputs.getInt("Enter Your Choice [1 to " + (this.size() - 2) + "]: ", "⚠ ️Enter from 1 to " + (this.size() - 2) + " ⚠️", 1, this.size() - 2);
    }

}
