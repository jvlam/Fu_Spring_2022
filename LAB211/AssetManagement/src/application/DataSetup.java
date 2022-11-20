package application;

import action_service.Inputs;
import buisiness_objects.Assets;
import buisiness_objects.People;
import ObjectList.AssetsList;
import ObjectList.BorrowInfoList;
import ObjectList.BorrowRequestList;
import ObjectList.PeopleList;
import buisiness_objects.BorrowInfo;
import buisiness_objects.BorrowRequest;
import java.io.IOException;
import java.text.ParseException;

public class DataSetup {

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("=======================================================================================================================");
        System.out.println("Asset Information");
        AssetsList asset = new AssetsList();
        asset.add(new Assets("A001", "Samsung projector", "white", 500, 3.2, 10));
        asset.add(new Assets("A002", "Macbook pro 2016", "sliver", 1000, 2.2, 5));
        asset.writeToFile();
//        asset.readFromFile();
        asset.displayAssetsList();
        System.out.println();
        
        System.out.println("=======================================================================================================================");
        System.out.println("Employee Information");
        PeopleList peopleList = new PeopleList();
        People person = new People("E160001", "Nguyen Hong Hiep", Inputs.getDateForm("12-06-2000"), "EM", "male", "e10adc3949ba59abbe56e057f20f883e") {
        };
        peopleList.add(person);
        
        person = new People("E160240", "Tran Dinh Khanh", Inputs.getDateForm("15-07-2002"), "EM", "male", "e10adc3949ba59abbe56e057f20f883e") {
        };
        peopleList.add(person);
        
        person = new People("E140449", "Le Buu Nhan", Inputs.getDateForm("10-07-2002"), "EM", "male", "e10adc3949ba59abbe56e057f20f883e") {
        };
        peopleList.add(person);
        
        person = new People("E160798", "Truong Le Minh", Inputs.getDateForm("03-12-2002"), "EM", "male", "e10adc3949ba59abbe56e057f20f883e") {
        };
        peopleList.add(person);
        
        person = new People("E160052", "Hoa Doan", Inputs.getDateForm("05-06-1990"), "MA", "male", "e10adc3949ba59abbe56e057f20f883e") {
        };
        peopleList.add(person);
        
        peopleList.writeToFile();
//        peopleList.readFromFile();
        peopleList.displayPeopleList();
        System.out.println();
        
        System.out.println("=======================================================================================================================");
        System.out.println("Borrow Request Information");
        BorrowRequestList bl = new BorrowRequestList();
        BorrowRequest br;
        br = new BorrowRequest("R001", "A001", "E140449", 1, Inputs.getDateFormAndHour("23-12-2021 13:17:56"));
        bl.add(br);
        br = new BorrowRequest("R002", "A002", "E160001", 1, Inputs.getDateFormAndHour("24-12-2021 12:18:56"));
        bl.add(br);
        br = new BorrowRequest("R003", "A001", "E160798", 1, Inputs.getDateFormAndHour("23-12-2021 11:19:56"));
        bl.add(br);
        br = new BorrowRequest("R007", "A002", "E160240", 1, Inputs.getDateFormAndHour("24-12-2021 10:10:56"));
        bl.add(br);
        bl.writeToFile();
//        bl.readFromFile();
        bl.displayRequestList();
        System.out.println();
        
        System.out.println("=======================================================================================================================");
        System.out.println("Borrow Information");
        BorrowInfoList bil = new BorrowInfoList();
        BorrowInfo bi;
        bi = new BorrowInfo("B001", "A001", "E160001", 1, Inputs.getDateFormAndHour("23-12-2021 15:13:46"));
        bil.add(bi);
        bi = new BorrowInfo("B002", "A001", "E160001", 2, Inputs.getDateFormAndHour("25-12-2021 16:14:56"));
        bil.add(bi);
        bi = new BorrowInfo("B003", "A002", "E160798", 3, Inputs.getDateFormAndHour("15-12-2021 17:15:52"));
        bil.add(bi);
        bi = new BorrowInfo("B007", "A001", "E160240", 2, Inputs.getDateFormAndHour("26-12-2021 12:16:53"));
        bil.add(bi);
        bil.writeToFile();
//        bil.readFromFile();
        bil.show();
        System.out.println("=======================================================================================================================");
    }
//        Student st = new Student("SE1", "lam", "vu", "male", Input.getDateForm("2-2-2021"), "V@gmail.com", "0234567981");
//        student.put("SE1", st);
//        st = new Student("SE2", "quan", "anh", "female", Input.getDateForm("3-1-2002"), "V@gmail.com", "0234567981");
//        student.put("SE2", st);
//        student.showList();
//        
//        Subject sj = new Subject("CSD", "algorithm", 3);
//        subject.put("CSD", sj);
//        sj = new Subject("DBI", "database", 3);
//        subject.put("DBI", sj);
//        subject.showList();
//        
//        stMark.add(new StudentGrade(st, sj, 8.0, 9.0, 5.0));
//        stMark.add(new StudentGrade(st, sj, 5.0, 7.0, 6.0));
//        stMark.add(new StudentGrade(st, sj, 7.0, 4.0, 7.0));
//        stMark.add(new StudentGrade(st, sj, 6.0, 6.0, 6.0));
//        stMark.showMark();
}
