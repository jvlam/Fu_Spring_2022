
package sample.dto;


public interface I_Menu {
    //add menu item , add text to the menu
    public void addItem(String msg);
    //get user choice to select the number
    public int getChoice();
    //show menu to the users
    public void showMenu();
    //confirm msg Y/N
}
