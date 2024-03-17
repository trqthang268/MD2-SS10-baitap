package session10_baitap.baitap02;
import java.util.Scanner;

public class StudentManager {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.startApplication();

    }

    public void startApplication() {
        // Khởi tạo sinh viên
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        //Nhập thông tin cho sinh viên
        System.out.println("Nhap thong tin sinh vien 1");
        student1.inputData();
        System.out.println("Nhap thong tin sinh vien 2");
        student2.inputData();
        System.out.println("Nhap thong tin sinh vien 3");
        student3.inputData();


        //Hiển thị thông tin sinh viên
        displayStudentInfo(student1);
        displayStudentInfo(student2);
        displayStudentInfo(student3);
    }

    private void displayStudentInfo(Student student) {
        System.out.println("------------------------------------------");
                     System.out.println("     Thông tin Sinh Viên");

        System.out.println("Tên Sinh Viên : " + student.getName());
                                  System.out.println("Tuổi          : " + student.getAge());
                                         System.out.println("Địa chỉ       : " + student.getAddress());

    }
}

class Student {

    private String name;
    private int age;

    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void inputData(){
        System.out.println("Nhap ten");
        this.name= StudentManager.scanner.nextLine();
        System.out.println("Nhap tuoi");
        this.age = Integer.parseInt(StudentManager.scanner.nextLine());
        System.out.println("Nhap dia chi");
        this.address= StudentManager.scanner.nextLine();
    }
}