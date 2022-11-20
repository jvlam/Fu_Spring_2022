package sample.utils;

import java.util.Scanner;

//Class chứa các hàm input để dành cho việc nhập dữ liệu từ bàn phím
public class Input {

    private static Scanner sc = new Scanner(System.in); //để private vì chỉ dùng Scanner nội bộ trong class

    public static int getInt(String msg, String errorMsg, int lowerBound, int upperBound) {
        int number;
//        boolean check = true;
        do {
            try {
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
//                break;         dùng return mạnh hơn break; vì break; chỉ mới thoát khỏi vòng lặp
//                check = false;
                return number;
            } catch (Exception e) {
                System.out.println(msg);
            }
        } while (true);
//        return number;
    }

    public static double getDouble(String msg, String errorMsg, double lowerBound, double upperBound) {
        double number = 0;
        boolean check = true;
        do {
            try {
                System.out.print(msg);
                number = Double.parseDouble(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (check);
        return number;
    }
//đối với getString thì kh cần tryCatch , vì nhập gì cũng convert thành kiểu kí tự

    public static String getString(String msg, String errorMsg) {
        String input = "";
        boolean check = true;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (!input.isEmpty()) {
                check = false;
            }else{
                System.out.println(errorMsg);
            }
        } while (check);
        return input;
    }

//    public static String getString(String msg, String error){
//        String input = "";
//        boolean check = true;
//        do {   
//            System.out.println(msg);
//            input = sc.nextLine();
//            if(input.length() == 0 || input.isEmpty()){
//                System.out.println("Error");
//            }else{
//                check = false;
//            }
//        } while (check);
//        return input;
//    }
    
    public static boolean confirmYesNo(String msg) {
        boolean check = true;
        String confirm = Input.getString(msg, msg);
        if ("Y".equalsIgnoreCase(confirm)) {
            check = false;
        }
        return check;
    }
    
}
