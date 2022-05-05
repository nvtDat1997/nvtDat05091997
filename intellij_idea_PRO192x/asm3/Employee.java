package Asm3;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Staff{ //Employee kế thừa từ Staff và implement từ lớp interface ICalculator
    private Double overtime;

    //khởi tạo đối tượng(constructor có tham số)
    public Employee(String name, String birthday, String code, Double salaryfactor,
                    String dayStart, Integer vacationDay, String department, Double overtime) {
        super(name, birthday, code, salaryfactor, dayStart, vacationDay, department);
        this.overtime = overtime;
    }

    //constructor không có tham số
    public Employee(){
    }

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }

    public void inputEmployee(){    //mặc định một số nhân viên ban đầu của công ty
    listStaff.add(new Employee("Đoàn Thiên", "2/7/1990", "E001", 2.0, "25/2/2017",
        3, "Project", 1.5));
    listStaff.add(new Employee("Lê Lan Anh", "28/3/1989", "E002", 2.5, "12/9/2015",
        5, "Project", 2.0));
    listStaff.add(new Employee("Nguyễn Thành", "15/2/1987", "E003", 2.5, "12/1/2016",
        4, "Project",3.0));
    listStaff.add(new Employee("Nguyễn Duy Tiến", "23/8/1994", "E007", 3.0, "3/1/2017",
            5, "Technical", 2.5));
    listStaff.add(new Employee("Nguyễn Đức Bảo", "29/7/1996", "E009", 2.5, "1/11/2017",
            4, "Technical", 1.0));
    listStaff.add(new Employee("Trần Phương Linh", "2/7/1995", "E012", 2.5, "17/8/2016",
            4, "Technical", 2.0));
    listStaff.add(new Employee("Phan Nhật Cường", "21/12/1991", "E023", 2.5, "5/11/2018",
            4, "Technical", 3.0));
    listStaff.add(new Employee("Nguyễn Thành Danh", "8/6/1990", "E015", 2.0, "12/12/2016",
            5, "Business", 1.0));
    listStaff.add(new Employee("Phạm Chí Hữu", "27/7/1993", "E013", 2.5, "12/11/2016",
            3, "Business", 1.5));
    listStaff.add(new Employee("Đặng Ánh Loan", "25/5/1998", "E021", 2.0, "14/11/2018",
            4, "Business",0.0));
    listStaff.add(new Employee("Duy long", "12/7/1990", "E010", 2.0, "12/11/2016",
            4, "Business", 0.5));
}

    @Override
    public void displayInformation() {      //hiển thị thông tin nhân viên từng bộ phận
        for (int i = 0; i < listDepartment.size(); i++){
            System.out.println("Nhân viên bộ phận " + listDepartment.get(i).getDepartmentName() + ":");
            for (int j = 0; j < listStaff.size(); j++){
                if(listDepartment.get(i).getDepartmentName().toLowerCase().
                        equals(listStaff.get(j).getDepartment().toLowerCase()))
                    System.out.print(listStaff.get(j));
            }
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

//    @Override
//    public Double calculateSalary() {
//        return super.getSalaryfactor()*BASICSALARYEMPLOYEE + this.getOvertime()*OVERTIMEMONEY;
//    }

    @Override
    public String toString() {      //toString() trả về kiểu hiển thị cho đối tượng
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", code='" + code + '\'' +
                ", salaryfactor=" + salaryfactor +
                ", dayStart='" + dayStart + '\'' +
                ", vacationDay=" + vacationDay +
                ", department='" + department + '\'' +
//                ", overtime='" + overtime+ '\'' +
                '}' + "\n";
    }
}

