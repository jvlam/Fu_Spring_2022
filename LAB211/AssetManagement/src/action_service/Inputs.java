package action_service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                if (number < min || number > max) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (check);
        return number;
    }

    public static double getDouble(String msg, String err, double min, double max) {
        boolean check = true;
        double number = 0;
        do {
            try {
                System.out.print(msg);
                number = Double.parseDouble(sc.nextLine());
                if (number < min || number > max) {
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
                System.out.print(msg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double getDoubleUpdate(String msg, String error, double min, double max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(msg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
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

    public static Date getDateFormAndHour(String s) throws ParseException {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:MM:SS");
        date = df.parse(s);
        return date;
    }

    public static String ConvertGetDateFormAndHour(Date date) {
        String s;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:MM:SS");
        s = df.format(date);
        return s;
    }

    public static Date getDateForm(String s) {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = df.parse(s);
        } catch (ParseException ex) {
        }
        return date;
    }

    public static String convertDate(Date date) {
        String s;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        s = df.format(date);
        return s;
    }

    public static String encryptMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
