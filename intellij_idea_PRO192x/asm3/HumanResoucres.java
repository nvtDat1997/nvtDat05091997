package Asm3;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanResoucres {
    public static void main(String[] args) {
        Manager manager = new Manager();    //khai báo đối tượng
        Employee employee = new Employee();
        Department department = new Department();
        Salary salary = new Salary();

        manager.inputManager();     //method mặc định ban đầu để thêm quản lí hiện đang làm tại cty
        employee.inputEmployee();   //method mặc định ban đầu để thêm nhân viên hiện đang làm tại cty

        System.out.println("Chào mừng bạn đến với trang chủ công ty TNHH WebKPI" + "\n\tNội dung:" +
                "\n\t\t1. Danh sách nhân viên hiện tại của công ty\n\t\t2. Thông tin các bộ phận của công ty" +
                "\n\t\t3. Nhân viên theo từng bộ phận\n\t\t4. Thêm nhân viên mới\n\t\t5. Tìm kiếm nhân viên" +
                "\n\t\t6. Hiển thị bảng lương nhân viên toàn công ty\n\t\t7. Thoát!");

        String reply = "";
        do {
            System.out.print("Nhập thông tin bạn quan tâm(1, 2, 3,...)?  ");
            Scanner sc = new Scanner(System.in);
            Integer function = sc.nextInt();
            if (function == 1) {      //hiển thị danh sách nhân viên hiện có của công ty
                manager.displayInformation();
//                employee.displayInformation();
            }

            else if (function == 2) {
                department.departmentcompany(); //method cập nhập thông tin vầ các bộ phận trong cty
                department.informationDepartment();     //hiển thị thông tin bộ phận của cty
            }

            else if (function == 3) {
                department.departmentcompany(); //method cập nhập thông tin vầ các bộ phận trong cty
                employee.displayInformation(); //hiển thị nhân viên của từng bộ phận
            }

            else if (function == 4) {
                Staff.addStaffNew();  //thêm nhân viên mới vào cty
            }

            else if (function == 5) {
                Staff.findStaff();    //tìm kiếm thông tin nhân viên trong cty
            }

            else if (function == 6) {       //hiển thị bảng lương nhân viên toàn công ty
                salary.calculateSalary();
                System.out.print("Danh sách tăng dần nhập vào 1, giảm dần nhập vào 2:  ");
                Integer list = sc.nextInt();
                sc.nextLine();
                if (list == 1){
                    salary.showlistTwo();
                    salary.displayInformation();
                }
                else {
                    salary.showlistOne();
                    salary.displayInformation();
                }
            }

            else  break;

            System.out.print("----------------------------------\nBạn có muốn xem thêm thông tin không (yes or no)?  ");
            reply = sc.next();
            reply = reply.toLowerCase();
        }while (reply.equals("y") || reply.equals("yes"));
        System.out.println("\n\n Cảm ơn bạn đã ghé thăm trang của chúng tôi!");
    }
}