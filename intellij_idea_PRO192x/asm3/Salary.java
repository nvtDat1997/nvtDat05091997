package Asm3;

import java.util.ArrayList;
import java.util.Comparator;

public class Salary extends Staff implements ICalculator {
    private ArrayList<Salary> listSalary;   //khai báo thuộc tính
    private Double salary;

    //constructor ko tham số
    public Salary() {
        this.listSalary = new ArrayList<>();    //khởi tạo danh sách lương nhân viên
    }

    //constructor chứa 3 tham số
    public Salary(String name, String code, Double salary) {
        super(name, code);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public Double calculateSalary() {       //hàm thiết lập giá trị cho danh sách lương nhân viên
        for (int i = 0; i < listStaff.size(); i++) {
            if (listStaff.get(i) instanceof Employee) {
                listSalary.add(new Salary(listStaff.get(i).getName(), listStaff.get(i).getCode(),
                        listStaff.get(i).getSalaryfactor() * BASICSALARYEMPLOYEE +
                                ((Employee) listStaff.get(i)).getOvertime() * OVERTIMEMONEY));
            }
            /*-----------------------------------------------------------------------------------*/
            if (listStaff.get(i) instanceof Manager) {
                if (((Manager) listStaff.get(i)).getPosition().toLowerCase().equals("business leader")) {
                    listSalary.add(new Salary(listStaff.get(i).getName(), listStaff.get(i).getCode(),
                            listStaff.get(i).getSalaryfactor() * BASICSALARYMANAGER + BUSINESSLEADER));
                }

                if (((Manager) listStaff.get(i)).getPosition().toLowerCase().equals("technical leader")) {
                    listSalary.add(new Salary(listStaff.get(i).getName(), listStaff.get(i).getCode(),
                            listStaff.get(i).getSalaryfactor() * BASICSALARYMANAGER + TECHNICALLEADER));
                }

                if (((Manager) listStaff.get(i)).getPosition().toLowerCase().equals("project leader")) {
                    listSalary.add(new Salary(listStaff.get(i).getName(), listStaff.get(i).getCode(),
                            listStaff.get(i).getSalaryfactor() * BASICSALARYMANAGER + PROJECTLEADER));
                }
            }
        }
        return null;
    }

    //sắp xếp danh sách giảm dần theo lương của nhân viên
    public void showlistOne() {
        Comparator<Salary> listIncrease = new Comparator<Salary>() {
            @Override
            public int compare(Salary o1, Salary o2) {
                return (int) (o2.salary - o1.salary);
            }
        };
        listSalary.sort(listIncrease);
    }

    //sắp xếp danh sách tăng dần theo lương của nhân viên
    public void showlistTwo() {
        Comparator<Salary> listDecrease = new Comparator<Salary>() {
            @Override
            public int compare(Salary o1, Salary o2) {
                return (int) (o1.salary - o2.salary);
            }
        };
        listSalary.sort(listDecrease);
    }

    @Override
    public void displayInformation() {  //hàm hiển thị bảng lương nhân viên
        for (int i = 0; i < listSalary.size(); i++) {
            System.out.print(listSalary.get(i));
        }
        listSalary.clear();
    }

    @Override
    public String toString() {
        return "Salary{" +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", salary='" + String.format("%.2f", salary) + " vnđ" + '\'' +
                '}' + "\n";
    }
}

