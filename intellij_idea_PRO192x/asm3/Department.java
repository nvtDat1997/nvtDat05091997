package Asm3;

import java.util.ArrayList;

public class Department{
    protected String departmentCode;     //khai báo thuộc tính đối tượng
    protected String departmentName;
    protected Integer employeeCurrent;
    protected static ArrayList<Department> listDepartment;
    static Integer x = 5, y = 5, z = 4;     //biến tĩnh để hiển thị số lượng nhân viên hiện tại

    //constructor có tham số
    public Department(String departmentCode, String departmentName, Integer employeeCurrent) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.employeeCurrent = employeeCurrent;
    }

    //constructor không có tham số
    public Department(){
        this.listDepartment = new ArrayList<>();
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getEmployeeCurrent() {
        return employeeCurrent;
    }

    public void departmentcompany(){    //method thêm thông tin các bộ phận vào 1 danh sách
        listDepartment.add(new Department("BSS", "Business", x));
        listDepartment.add(new Department("TNC", "Technical", y));
        listDepartment.add(new Department("PJT", "Project", z));
    }

    public void informationDepartment(){        //hiển thị thông tin bộ phận
        for (int i = 0; i < listDepartment.size(); i++)
            System.out.println(listDepartment.get(i).toString());
        listDepartment.clear();
    }

    @Override
    public String toString() {
            return "Department{" +
                    "departmentCode='" + this.getDepartmentCode() + '\'' +
                    ", departmentName='" + this.getDepartmentName() + '\'' +
                    ", employeeCurrent=" + this.getEmployeeCurrent() + '\'' +
                    '}';
    }
}
