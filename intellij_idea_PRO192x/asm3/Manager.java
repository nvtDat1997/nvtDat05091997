package Asm3;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Staff{  //Manager kế thừa từ Staff và implement từ lớp interface ICalculator
    private String position;    //khai báo thuộc tính

    //constructor có tham số
    public Manager(String name, String birthday, String code, Double salaryfactor,
                   String dayStart, Integer vacationDay, String department, String position) {

        super(name, birthday, code, salaryfactor, dayStart, vacationDay, department);
        this.position = position;
    }

    //constructor không chứa tham số
    public Manager() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void inputManager(){     //method thêm mặc định ban đầu thêm một số quản lí vào danh sách nhân viên cty
        listStaff.add(new Manager("Đoàn Như Hải", "24/5/1985", "M007", 3.0, "25/2/2017",
                7, "Technical", "Technical Leader"));
        listStaff.add(new Manager("Lê Bích Ngọc", "11/12/1987", "M002", 2.5, "12/9/2016",
                5, "Business", "Business Leader"));
        listStaff.add(new Manager("Nguyễn Thanh Bình", "3/8/1987", "M001", 3.5, "12/11/2016",
                4, "Project", "Project Leader"));
    }

    @Override
    public void displayInformation() {  //hiển thị thông tin các nhân viên của công ty
        for(int i = 0; i < listStaff.size(); i++) {
            System.out.print(listStaff.get(i));
        }
    }

//    @Override
//    public Double calculateSalary() {
//        Double salary;
//        if(position.toLowerCase().equals("business leader"))  salary = super.getSalaryfactor()*BASICSALARYMANAGER + BUSINESSLEADER;
//        else if(position.toLowerCase().equals("project leader"))  salary = super.getSalaryfactor()*BASICSALARYMANAGER + PROJECTLEADER;
//        else  salary = super.getSalaryfactor()*BASICSALARYMANAGER + TECHNICALLEADER;
//        System.out.println(salary);
//        return salary;
//    }

    @Override
    public String toString() {  //toString() trả về kiểu hiển thị cho đối tượng
        return "Manager{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", code='" + code + '\'' +
                ", salaryfactor=" + salaryfactor +
                ", dayStart='" + dayStart + '\'' +
                ", vacationDay=" + vacationDay +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                '}' + "\n";
    }
}