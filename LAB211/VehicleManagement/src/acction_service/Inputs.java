package acction_service;

import java.util.Scanner;


public class Inputs {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, String err, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                System.out.print(msg);  
                number = Integer.parseInt(sc.nextLine());
                if(number < min || number > max){
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (check);
        return number;
    }

    public static String getString(String msg, String error) {
        boolean check = true;
        String result = null;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(error);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getStringUpdate(String msg, String oldData) {
        String result = oldData;
        System.out.print(msg);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int getIntUpdate(String msg, String error, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(msg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }
    
    
    
    public static boolean confirmYesNo(String msg, String error) {
        boolean check = true;
        String confirm = Inputs.getString(msg, error);
        if ("Y".equalsIgnoreCase(confirm)) {
            check = false;
        }
        return check;
    }


}
