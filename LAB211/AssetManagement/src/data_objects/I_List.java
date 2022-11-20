
package data_objects;
    
import ObjectList.PeopleList;
import java.io.IOException;


public interface I_List {
    
    public abstract void add(PeopleList checkLogin) throws IOException;
    
    public abstract void update(PeopleList checkLogin);
    
    public abstract void search();
    
}
