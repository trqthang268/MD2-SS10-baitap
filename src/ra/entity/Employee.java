package ra.entity;

import ra.config.InputMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

//    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String idEmployee;
    private String nameEmployee;
    private Date birthday;
    private String address;
    private String phone;
    private double basicSalary;
    private double rate;

    public Employee(String idEmployee, String nameEmployee, Date birthday, String address, String phone, double basicSalary, double rate) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.basicSalary = basicSalary;
        this.rate = rate;
    }

    public Employee() {
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public void inputData() throws ParseException {
        while (true) {
            System.out.println("Nhập mã nhân viên");
            String inputId = InputMethods.getString();
            if (inputId.startsWith("P")) {
                this.idEmployee = inputId;
                break;
            } else {
                System.out.println("Mã phải bắt đầu bằng P");
            }
        }

        System.out.println("Nhập tên nhân viên");
        this.nameEmployee = InputMethods.getString();

        System.out.println("Nhập ngày tháng năm sinh");
        this.birthday = InputMethods.getDate();

        System.out.println("Nhập địa chỉ nhân viên");
        this.address = InputMethods.getString();

        while (true) {
            System.out.println("Nhập số điện thoại nhân viên");
            String inputPhone = InputMethods.getString();
            String regexPhone = "((^(\\+84|84|0|0084){1})(3|5|7|8|9))+([0-9]{8})$";
            boolean checkPhone = inputPhone.matches(regexPhone);
            if (checkPhone) {
                phone = inputPhone;
                System.out.println("Số điện thoại hợp lệ");
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ");
            }
        }

        System.out.println("Nhập lương cơ bản của nhân viên");
        this.basicSalary = InputMethods.getDouble();
        System.out.println("Nhập hệ số năng suất");
        this.rate = InputMethods.getDouble();
    }

    public void displayData(){
        System.out.printf("Employee{" +
                "idEmployee='" + idEmployee + '\'' +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", basicSalary=" + basicSalary +
                ", rate=" + rate +
                '}');
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Employee{" +
                "idEmployee='" + idEmployee + '\'' +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", birthday=" + sdf.format(birthday) +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", basicSalary=" + basicSalary +
                ", rate=" + rate +
                '}';
    }
}
