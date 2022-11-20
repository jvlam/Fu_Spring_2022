package sample.controllesrs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sample.dto.Food;
import sample.dto.I_List;
import sample.utils.Input;
//Những Câu Hỏi Ở Phần này
//liệu chỉ cần dùng đúng một hàm tìm kiếm ID được không

public class FoodList extends ArrayList<Food> implements I_List {
// Biến FoodList thành một HashMap và nó có thêm những thuộc phương thức của I_List
// Mục Tiêu là sử dụng được những method có trong ArrayList đồng thời method của I_List

    private Scanner sc = new Scanner(System.in);

    //Method findPosition trả về vị trí của một Object
    //convention: -1 sẽ không tìm thấy
    //trả về >= 0 vị trí tìm thấy trong mảng
//    @Override 
//    public int findPosition(String code) {
//        int index;
////        index = this.indexOf(new Food(code)); // khi truyền vào tham số code thì hàm indexOf(Object) trả về index của ArrayList 
//        index = indexOf(new Food(code));        //indexOf dùng muốn so sánh được id của Vehicle thì trong class Vehicle phải có hàm so sánh đó là equal 
    //
//        return index;                            // nếu kh tìm thấy nó sẽ trả về -1
//    }
//========================================================================================================//   
    //find Code sẽ nhận vào id của hàm lợi dụng nó sau đó trả về index cho hàm lợi dụng
    //không tìm thấy sẽ trả về -1
    @Override
    public int findIDReturnIndex(String id) {
        int index;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(new Food(id))) {
                return index = i;
            }
        }
        return -1;
    }

//    public boolean findIDContains(){
//        boolean check = true;
//        do {            
//            String id = Input.getString("Enter your ID", "Enter ID again!!!");
//            check = this.contains(new Food(id));
//            if(check){
//                check = false;
//            }else{
//                System.out.println("ID duplicate");
//            }
//        } while (true);
//    }
    //Method findID return an Object sử dụng cho các hàm cần tìm kiếm OBJ để sử lý
    @Override
    public Food findIDReturnObject(String ID) {
        if (this.isEmpty()) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(ID)) { //vì sao id chấm so sánh đc với id khác Vì id có kiểu dữ liệu là 
                                                           //String Reference variable nên chấm đc, còn kiểu int hay double chỉ là primitive data type.
                return this.get(i);                        
            }
        }
        return null;
    }
//==========================================================================================================//

    @Override
    public void add() {
        boolean check = true;
        String id;
        //        do {
        //            id = Input.getString("Enter Food ID: ", "input id ⚠");
        //            //lợi dụng findIDReturnIndex để kiểm tra xem ID có tồn tại hay chưa
        //            int index = this.findIDReturnIndex(id);
        //            if (index == -1) {
        //                check = false;
        //            } else {
        //                System.out.println("⚠⚠ code duplicate ⚠⚠");
        //            }
        //        } while (check);

        do {
            id = Input.getString("Enter your ID", "Enter ID again!!!");
            check = this.contains(new Food(id));
            if (check) {
                check = false;
            } else {
                System.out.println("ID duplicate");
            }
        } while (check);

        String name = Input.getString("Enter Food Name: ", "Please input food name again ⚠");
        double weight = Input.getDouble("Enter Food Weight: ", "Please input food weight again ⚠", 1.0, 200.0);
        String type = Input.getString("Enter Type Of Food: ", "Please input type of food again ⚠️");
        String place = Input.getString("Enter Place To Put The Food: ", "Please input place to put the food again ⚠");
        int expiredDate = Input.getInt("Enter Expired Date: ", "Please input expired Date again ⚠", 1, 3000);

        this.add(new Food(id, name, weight, type, place, expiredDate));
        System.out.println("The Food Has Been Added Successfully");
    }
//============================================================================================================//
    //hàm này nhận vào tên muốn tìm sau đó trả về một Obj để hàm lợi dụng nó sử dụng

    public Food searchObjectByName(String name) {
        if (this.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getName().equalsIgnoreCase(name)) {
                    return this.get(i);
                }
            }
        }
        return null; //return null khong mang gia tri nao ca
        // null chỉ gán đc cho reference data type nhưng primitive data thì kh
    }

    @Override
    public void searchByname() {
        String name = Input.getString("Enter The Name You Want To Search: ", "");
        //lợi dụng hàm searchOjectByName để tìm kiếm theo tên
        Food findName = this.searchObjectByName(name);
        if (findName == null) {
            System.out.println("The food does not exist");
        } else {
            findName.showInfo();

            // System.out.println(findName);
            //khi sout (biến con trỏ, biến obj, biến reference) mặc định hàm toString()
            //được gọi , chỉ toString() mới được ưu tiên như vậy , MUỐN DÙNG HÀM KHÁC THÌ BẮT BUỘC . THÔNG QUA OBJ
            //không có hàm toString()  vẫn gọi đc qua lệnh sout khi đó JVM sẽ in ra
            //mã băm hash-number của vùng ram mà object đang nằm
        }
    }
//=============================================================================================================//

    @Override
    public void removeByID() {
        String id = Input.getString("Enter ID of the food you want to delete: ", "Please input the Id again ⚠️");
        //tiếp tục lợi dụng hàm findIDReturnObject
        Food meal = this.findIDReturnObject(id);
        if (meal == null) {
            System.out.println("Can not find the ID ⚠");
        } else {
            String confirm = Input.getString("Are You Sure That You Want To Delete The ID (Y/N): ", "Input ID again ⚠");
            if ("Y".equalsIgnoreCase(confirm)) {
                this.remove(meal);
                System.out.println("The Food is removed Successfully");
            }
        }
    }
//=============================================================================================================//

    @Override
    public void printListDescendingByExpiredDate() {
        Collections.sort(this);
        Collections.reverse(this);
        System.out.println("Descending order of expired date");
        for (int i = 0; i < this.size(); i++) {
            this.get(i).showInfo();
        }
    }
//==============================================================================================================//

    public int numberOfFood() {
        return this.size();
    }
    
    
    public void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("Food.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Food obj : this) {
                oos.writeObject(obj);
            }
            System.out.println("Employee Information");
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }
    
    
    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("Food.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Food obj = null;
            while (fis.available() > 0) {
                obj = (Food) ois.readObject();
                this.add(obj);
                System.out.println(obj.toString());
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

}
