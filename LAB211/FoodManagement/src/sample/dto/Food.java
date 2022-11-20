package sample.dto;

public class Food implements Comparable<Object> {

    private String id;
    private String name;
    private double weight;
    private String type;
    private String place;
    private int expiredDate;

    public Food() {
    }

    public Food(String id) {
        this.id = id;
    }

    public Food(String id, String name, double weight, String type, String place, int expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace() {
        this.place = place;
    }

    public int getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(int expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void showInfo() {
        System.out.printf("|Food|ID: %5s|Name: %-10s|Weight: %4.1f|Type: %-5s|Place: %5s|Expired Date: %5d|\n",
                getId(), getName(), getWeight(), getType(), getPlace(), getExpiredDate());
    }

    @Override
    public String toString() {
        return String.format("|Food|ID: %-5s|Name: %-5s|Weight: %-4.1f|Type: %-5s|Place: %-5s|Expired Date: %-5d|\n",
                getId(), getName(), getWeight(), getType(), getPlace(), getExpiredDate());
    }

    @Override
    public int compareTo(Object o) {
        Food other = (Food) o;
        return this.expiredDate - other.expiredDate;
    }

}
