
package sample.dto;

//Interface can not declare private and protected variables
//public và final modifier không bắt buộc
//method in interface are PUBLIC and ABSTRACT
//Interface mặc định các phương thức là ABSTRACT nên không cần thêm abstract vào method

public interface I_List {
   //find the position of element which has code equal paramater code
   public int findIDReturnIndex(String id);
   //find the id of the element and return the object
   public Food findIDReturnObject(String id);
   //add food to the 
   public void add();
   //search food by name
   public void searchByname();
   //remove by id , before remove  show confirm msg
   public void removeByID();
   //print the list in descending order of expired date
   public void printListDescendingByExpiredDate();
}
