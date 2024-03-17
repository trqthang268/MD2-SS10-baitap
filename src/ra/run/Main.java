package ra.run;

import ra.config.InputMethods;
import ra.entity.Employee;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Employee[] employees = new Employee[0];

    public static void main(String[] args) throws ParseException {
        while (true) {
            System.out.println("================MENU================");
            System.out.println("1.\tThêm mới 1 nhân viên \n" +
                    "2.\tHiển thị danh sách thông tin nhân viên \n" +
                    "3.\tXem thông tin nhân viên theo mã nhân viên\n" +
                    "4.\tCập nhật thông tin nhân viên\n" +
                    "5.\tXóa nhân viên\n" +
                    "6.\tTìm kiếm nhân viên theo tên (tương đối)\n" +
                    "7.\tSắp xếp và hiển thị danh sách nhân viên theo tên từ a - z\n" +
                    "8.\tThoát\n");
            System.out.println("Nhập chức năng tùy chọn:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmp();
                    break;
                case 3:
                    searchIdEmp();
                    break;
                case 4:
                    updateEmp();
                    break;
                case 5:
                    deleteEmp();
                    break;
                case 6:
                    searchByName();
                    break;
                case 7:
                    sortEmployeeAtoZ();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    break;

            }
        }
    }

    public static Employee findId(String id) {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i].getIdEmployee(), id)) {
                return employees[i];
            }
        }
        return null;
    }

    //    Thêm mới 1 nhân viên
    private static void addEmployee() throws ParseException {
        System.out.println("Nhập số lượng nhân viên muốn nhập:");
        int count = InputMethods.getInteger();
        Employee[] newEmployee = new Employee[employees.length + count];
        for (int i = 0; i < employees.length; i++) {
            newEmployee[i] = employees[i];
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập nhân viên số " + (i + 1));
            Employee newEm = new Employee();
            newEm.inputData();
            newEmployee[employees.length + i] = newEm;
        }
        employees = newEmployee;
    }

    //    Hiển thị danh sách thông tin nhân viên
    private static void displayEmp() {
        if (employees.length == 0) {
            System.out.println("Danh sách nhân viên trống");
        } else {
            System.out.println("Danh sách nhân viên :");
            for (Employee e : employees) {
                e.displayData();
            }
        }
    }

    //    Xem thông tin nhân viên theo mã nhân viên
    private static void searchIdEmp() {
        if (employees.length == 0) {
            System.out.println("Danh sách nhân viên trống");
            return;
        }
        System.out.println("Nhập mã nhân viên cần tìm");
        String idSearch = InputMethods.getString();
        boolean checkSearch = false;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i].getIdEmployee(), idSearch)) {
                System.out.println("Nhân viên cần tìm là :");
                employees[i].displayData();
                checkSearch = true;
                break;
            }
        }
        if (!checkSearch) {
            System.out.println("Không tìm thấy nhân viên với mã " + idSearch);
        }
    }

    //    Cập nhật thông tin nhân viên
    private static void updateEmp() throws ParseException {
        if (employees.length == 0) {
            System.out.println("Danh sách nhân viên trống");
            return;
        }
        System.out.println("Nhập mã nhân viên cần cập nhật");
        String idUpdate = InputMethods.getString();
        boolean checkUpdate = false;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i].getIdEmployee(), idUpdate)) {
                System.out.println("Nhập thông tin cập nhật");
                employees[i].inputData();
                System.out.println("Đã cập nhật thông tin");
                checkUpdate = true;
            }
        }
        if (!checkUpdate) {
            System.out.println("Không tìm thấy nhân viên với mã " + idUpdate);
        }
    }

    private static void deleteEmp() {
        if (employees.length == 0) {
            System.out.println("Danh sách nhân viên trống");
            return;
        }
        System.out.println("Nhập mã nhân viên cần xóa");
        String idDelete = InputMethods.getString();
        if (findId(idDelete) == null) {
            System.out.println("Không thấy id cần xóa");
            return;
        }
        Employee[] newEmployees = new Employee[employees.length - 1];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getIdEmployee() != idDelete) {
                newEmployees[index++] = employees[i];
            }
        }
        employees = newEmployees;
        System.out.println("Xóa thành công nhân viên có mã " + idDelete);
    }

    //    Tìm kiếm nhân viên theo tên (tương đối)
    private static void searchByName() {
        if (employees.length == 0) {
            System.out.println("Danh sách nhân viên trống");
            return;
        }
        System.out.println("Nhập mã nhân viên cần tìm");
        String searchName = InputMethods.getString();
        boolean checkSearch = false;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i].getNameEmployee(), searchName)) {
                System.out.println("Nhân viên cần tìm là :");
                employees[i].displayData();
                checkSearch = true;
                break;
            }
        }
        if (!checkSearch) {
            System.out.println("Không tìm thấy nhân viên với tên " + searchName);
        }
    }

    //    Sắp xếp và hiển thị danh sách nhân viên theo tên từ a - z
    private static void sortEmployeeAtoZ() {
        if (employees.length == 0) {
            System.out.println("Danh sách nhân viên trống");
            return;
        }
        Arrays.sort(employees, (employee1, employee2) ->
                employee1.getNameEmployee().compareToIgnoreCase(employee2.getNameEmployee())
        );
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Danh sách nhân viên");
            employees[i].displayData();
        }
    }
}