
package sample.controllesrs;

import java.util.ArrayList;
import sample.dto.I_Menu;
import sample.utils.Input;
//import sample.utils.Input;

                                            
public class Menufuction extends ArrayList<String> implements I_Menu{
    //nếu không có Constructor này thì điều gì sẽ sảy ra ???
    
//    public Menufuction(){
//        super(); 
//    }
    
    @Override
    public void addItem(String msg) {
        this.add(msg);
    }

    @Override
    public int getChoice() {
        int result = Input.getInt("Enter your choice(1 to 5): ", "Enter 1 to 5", 1, 5);
        return result;
    }

    @Override
    public void showMenu() {
        for(int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
    
}
