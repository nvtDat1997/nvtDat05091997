package Asm3;

import tesst123.Salary;

import java.util.ArrayList;

public interface ICalculator {  //lớp interface
    final Double BASICSALARYEMPLOYEE = 3000000.0;   //khai báo các hằng trong việc tính lương để sau này dễ cập nhật
    final Double OVERTIMEMONEY = 200000.0;
    final Double BASICSALARYMANAGER = 5000000.0;
    final Double BUSINESSLEADER = 8000000.0;
    final Double TECHNICALLEADER = 6000000.0;
    final Double PROJECTLEADER = 5000000.0;
    public Double calculateSalary();    //hàm tính lương
}