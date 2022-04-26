import java.util.Date;

public class Employee {
    private String name;
    private String email;
    private Date dateofBirtH;
    private double salary;

    public Employee(String name, String email, Date dateofBirtH, double salary) {
        this.name = name;
        this.email = email;
        this.dateofBirtH = dateofBirtH;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateofBirtH() {
        return dateofBirtH;
    }

    public void setDateofBirtH(Date dateofBirtH) {
        this.dateofBirtH = dateofBirtH;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
