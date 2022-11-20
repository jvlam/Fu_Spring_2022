
package buisiness_objects;

import action_service.Inputs;
import java.io.Serializable;
import java.util.Date;


public abstract class People implements Serializable{
    private String employID;
    private String name;
    private Date birthdate;
    private String role;
    private String sex;
    private String password;

    public People(String id) {
        this.employID = id;
    }

    public People() {
    }
    
    public People(String id, String name, Date birthdate, String role, String sex, String password) {
        this.employID = id;
        this.name = name;
        this.birthdate = birthdate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public String getEmployID() {
        return employID;
    }

    public void setEmployID(String employID) {
        this.employID = employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "[" + "employID=" + employID + ", name=" + name + ", birthdate=" + Inputs.convertDate(birthdate) + ", role=" + role + ", sex=" + sex + ", password=" + password + ']';
    }
    
    public void display() {
        System.out.printf("|employID: %s|Name: %s|birthDate: %s|Role: %s|Sex: %s|PassWord: %s|\n",
                this.getEmployID(), this.getName(),Inputs.convertDate(birthdate), this.getRole(), this.getSex(), this.getPassword());
    }
    
    @Override
    public boolean equals(Object obj) {
        People o = (People) obj;
        return this.employID.equalsIgnoreCase(o.employID);
    }
    
}
