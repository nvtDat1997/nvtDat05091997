package Asm3;

import tesst123.Salary;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Staff extends Department{ //Staff kế thừa từ Department
    protected String name;      //khai báo thuộc tính đối tượng
    protected String birthday;
    protected String code;
    protected Double salaryfactor;
    protected String dayStart;
    protected Integer vacationDay;
    protected String department;
    protected static ArrayList<Staff> listStaff;

    //constructor có tham số
    public Staff(String name, String birthday, String code, Double salaryfactor,
                 String dayStart, Integer vacationDay, String department) {
        this.name = name;
        this.birthday = birthday;
        this.code = code;
        this.salaryfactor = salaryfactor;
        this.dayStart = dayStart;
        this.vacationDay = vacationDay;
        this.department = department;
    }

    //constructor không tham số
    public Staff() {
        this.listStaff = new ArrayList<>();
    }

    public Staff(String name, String code){
        this.name = name;
        this.code = code;
    }

    //các phương thức get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setAge(String birthday) {
        this.birthday = birthday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getSalaryfactor() {
        return salaryfactor;
    }

    public void setSalaryfactor(Double salary) {
        this.salaryfactor = salary;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public Integer getVacationDay() {
        return vacationDay;
    }

    public void setVacationDay(Integer vacationDay) {
        this.vacationDay = vacationDay;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //tìm nhân viên
    public static void findStaff(){
        String name = "";   //khai báo biến
        String code = "";
        String reply = "";
        Integer count = 0;
        do {
            Scanner sc = new Scanner(System.in);    //gọi hàm Scanner
            System.out.print("Nhập thông tin muốn tìm (theo tên nhập vào 1, theo mã nhân viên nhập vào 2): ");
            Integer x = sc.nextInt();       //yêu cầu người dùng nhập vào để lấy giá trị biến x
            sc.nextLine();      //loại bỏ trường hợp name phía sau nhận giá trị nút enter
            if (x == 1) {
                System.out.print("Nhập vào tên nhân viên bạn muốn tìm: ");
                name = sc.nextLine();
                for (int i = 0; i < listStaff.size(); i++) {    //vòng lặp for để xét điều kiện cho giá trị name nhập vào
                    if (name.toLowerCase().equals(listStaff.get(i).getName().toLowerCase())) {
                        System.out.println(listStaff.get(i));
                        count += 1;     //biến count tăng lên khi có nhân viên được tìm thấy
                    }
                }
                if(count == 0) System.out.println("Không tìm thấy nhân viên!");
            }
            /*---------------------------------------------------------------------*/
            else {
                count = 0;
                System.out.print("Nhập mã nhân viên bạn muốn tìm: ");
                code = sc.next();
                for (int i = 0; i < listStaff.size(); i++) {  //vòng lặp for để xét điều kiện cho giá trị code nhập vào
                    if (code.toLowerCase().equals(listStaff.get(i).getCode().toLowerCase())){
                        System.out.println(listStaff.get(i));
                        count += 1;
                    }
                }
                if(count == 0)  System.out.println("Không tìm thấy nhân viên!");
            }
            System.out.print("Bạn có muốn tìm thêm nhân viên khác (yes or no)?  ");
            reply = sc.next();
            reply = reply.toLowerCase();
        }while (reply.equals("y") || reply.equals("yes"));      //vòng lặp do-while để biết người dùng có muốn
    }                                                                       //dừng việc tìm kiếm hay ko

    //thêm nhân viên mới
    public static void addStaffNew(){
        String name, birthday, code, startWork, department;     //khai báo biến
        Double salaryfactor, overtime = 0.0;    //nhân viên mới nên mặc định overtime = 0
        Integer vacation;
        String reply = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Thêm nhân viên mới: \nHọ và Tên: ");
            name = sc.nextLine();
            System.out.print("Sinh ngày (ngày/tháng/năm sinh): ");
            birthday = sc.nextLine();
            System.out.print("Mã nhân viên: ");
            code = sc.next();
            System.out.print("Hệ số lương: ");
            salaryfactor = sc.nextDouble();
            System.out.print("Ngày vào làm: ");
            startWork = sc.next();
            System.out.print("Số ngày nghỉ phép: ");
            vacation = sc.nextInt();
            System.out.print("Bộ phận làm việc: ");
            department = sc.next();
            /*---------------------------------------------------------------------*/
            if(department.toLowerCase().equals("business"))   x += 1;   //xét điều kiện để tăng số lượng nhân viên hiện tại
            if(department.toLowerCase().equals("technical"))   y += 1;      //sau khi thêm vào nhân viên mới
            if(department.toLowerCase().equals("project"))   z += 1;
            /*---------------------------------------------------------------------*/
            System.out.print("Nhân viên bạn đang thêm có phải là quản lí ko (yes or no)? ");
            String ex = sc.next();
            sc.nextLine(); //tránh việc nhận dấu enter làm giá trị của biến position phía sau
            ex = ex.toLowerCase();
            /*---------------------------------------------------------------------*/
            if(ex.equals("y") || ex.equals("yes")){
                System.out.print("Chức vụ: ");
                String position = sc.nextLine();

                listStaff.add(new Manager(name, birthday, code, salaryfactor, startWork, vacation, department, position));
                //thực hiện việc thêm quản lí mới vào danh sách
            }
            else {
                listStaff.add(new Employee(name, birthday, code, salaryfactor, startWork, vacation, department, overtime));
                //thêm nhân viên mới vào danh sách
            }
            /*---------------------------------------------------------------------*/
            System.out.print("Thêm nhân viên khác? (yes or no)  ");
            reply = sc.next();
            sc.nextLine();
            reply = reply.toLowerCase();
            /*---------------------------------------------------------------------*/
        }while (reply.equals("y") || reply.equals("yes"));  //xác định người dùng có muốn tiếp tục chức năng
    }

//    //in ra thông tin nhân viên từng bộ phận
//    public static void StaffDepartment(){
//        for (int i = 0; i < listDepartment.size(); i++){
//            System.out.println("Nhân viên bộ phận " + listDepartment.get(i).getDepartmentName() + ":");
//            for (int j = 0; j < listStaff.size(); j++){
//                if(listDepartment.get(i).getDepartmentName().toLowerCase().
//                        equals(listStaff.get(j).getDepartment().toLowerCase()))
//                    System.out.print(listStaff.get(j));
//            }
//            System.out.println("-------------------------------------------------------------------------------");
//        }
//    }

    @Override
    public String toString() {
        return "Staff{" +
                "name ='" + name + '\'' +
                ", birthday =" + birthday +
                ", code ='" + code + '\'' +
                ", salaryfactor= " + salaryfactor +
                ", dayStart ='" + dayStart + '\'' +
                ", vacationDay =" + vacationDay +
                ", department ='" + department + '\'' +
                '}';
    }

    public abstract void displayInformation();  //phương thức trừu tượng
}
