package asm2;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class OperationToProduct {
    //khai báo đối tượng
    Mylist mylist = new Mylist();
    MyStack myStack = new MyStack();
    MyQueue myQueue = new MyQueue();

    //khai báo biến
    private String ID = "ID";
    private String Title = "Title";
    private String Quantity = "Quantity";
    private String Price = "Price";

    //Hàm đọc file và lưu dữ liệu vào danh sách móc nối
    public void readFileSaveDataInMylist() throws IOException, ParseException {
        File file1 = new File("Data.txt");
        Scanner scan = new Scanner(file1);
        while (scan.hasNext()) {
            String x = scan.next();
            String y = scan.next();
            Integer z = scan.nextInt();

            //khắc phục lỗi định dạng dấu phân cách (dấu chấm, dấu phẩy) trong trình biên dịch số thực
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            double t = numberFormat.parse(scan.next().replace(",",".")).doubleValue();

            mylist.addLast(new Product(x, y, z, t));
        }
        scan.close();
    }

    public void inputAddLast(Scanner sc) throws ParseException {    //Nhập và thêm sản phẩm vào cuối danh sách móc nối
        System.out.println("Nhập thông tin sản phẩm:");
        System.out.print("Mã sp: ");
        String code = sc.next();
        System.out.print("Tên sp: ");
        String name = sc.next();
        System.out.print("Số lượng: ");
        Integer quantity = sc.nextInt();
        System.out.print("Đơn giá: ");
        String price = sc.next();
        //khắc phục lỗi định dạng dấu phân cách (dấu chấm, dấu phẩy) trong trình biên dịch số thực
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        double Price = numberFormat.parse(price.replace(",",".")).doubleValue();

        mylist.addLast(new Product(code,name,quantity,Price));
    }

    public void show(OutputStreamWriter out) throws IOException{ //duyệt từng phần tử và in dữ liệu ra màn hình
        if (AS2_Main.choice == 9){
            myStack.show(out);      //Stack
        }
        else if (AS2_Main.choice == 10){
            myQueue.show(out);      //Queue
        }
        else{
            System.out.printf(String.format("%-30s",ID) + String.format("%-30s",Title) + String.format("%-20s",Quantity) +
                    String.format("%-20s",Price) + "\n" +
                    "--------------------------------------------------------------------------------------\n");
            out.write("------------------------------------------\n\n" +    //ghi output vào file
                    String.format("%-30s",ID) + String.format("%-30s",Title) + String.format("%-20s",Quantity) +
                    String.format("%-20s",Price) + "\n" +
                    "--------------------------------------------------------------------------------------\n");
            mylist.length(out);     //danh sách móc nối
        }
    }

    public void SaveDataInFile(OutputStreamWriter out) throws IOException{    //lưu dữ liệu của danh sách móc nối vào file
        mylist.saveInFile();
        System.out.println("Successfully!");
        out.write("\nSuccessfully!\n");
    }

    public void findProductById(OutputStreamWriter out, Scanner sc) throws IOException{ //tìm sản phẩm trong danh sách theo mã
        System.out.print("Nhập mã sp: ");
        String id = sc.next();  //Yêu cầu người dùng nhập giá trị mã sản phẩm cần tìm
        mylist.FindID(out, id);  //Hàm thực thi
    }

    public void deleteById(OutputStreamWriter out, Scanner sc) throws IOException{ //xóa sản phẩm trong danh sách theo mã
        System.out.print("Nhập mã sp: ");
        String id = sc.next();  //Yêu cầu người dùng nhập giá trị mã sản phẩm cần xóa
        mylist.DeleteID(out, id);    //Hàm thực thi
    }

    //hàm sắp xếp dữ liệu theo mã
    public void InsertionSortData(OutputStreamWriter out) throws IOException{
        ArrayList<Product> listProduct = new ArrayList<>(); //khởi tạo danh sách đối tượng
        mylist.InsertionSort(out, listProduct);
    }

    //hàm trả về giá trị để sử dụng trong hàm displayBinary() phía dưới
    public Integer value(){
        if(mylist.Quantity() < 0){
            return -1;
        }
        else{
            return mylist.Quantity();
        }
    }

    //hàm chuyển đổi và hiển thị dữ liệu số lượng của sản phẩm đầu tiên ra hệ nhị phân
    public ArrayList<Integer> displayBinary(OutputStreamWriter out, Integer x, ArrayList<Integer> listIntegers) throws IOException{
        if(x < 1){
            if (value() == 0){  //trường hợp số lượng sản phẩm là 0
                System.out.println("Quantity = (0)");
                out.write("\nQuantity = (0)\n");
            }
            else if(value() == -1){     //trường hợp số lượng sản phẩm âm ( < 0, có thể do người dùng nhập sai)
                System.out.println("Số lượng sản phẩm không hợp lệ vui lòng kiểm tra lại!");
                out.write("\nSố lượng sản phẩm không hợp lệ vui lòng kiểm tra lại!\n");
            }
            else{
                String result = "";
                for (int i = listIntegers.size()-1; i >= 0; i--){
                    result += listIntegers.get(i);
                }
                System.out.printf("Quantity = %d => (%s)\n", value(), result);
                out.write("\nQuantity = " + value() + " => (" + result + ")\n");
            }
        }
        else {
            listIntegers.add(x%2);  //lưu phần dư khi lấy x chia cho 2 vào danh sách số nguyên đã tạo ở trên
            displayBinary(out, x/2, listIntegers);   //gọi lại hàm với tham số truyền vào x = x/2 (đệ quy)
        }
        return listIntegers;
    }

    //hàm đọc và lưu dữ liệu từ file vào Stack and Queue
    public void readFileSaveDataInMyStackAndMyQueue(OutputStreamWriter out) throws IOException, ParseException {
        File file1 = new File("data111.txt");
        Scanner scan = new Scanner(file1);
        while (scan.hasNext()) {
            String x = scan.next();
            String y = scan.next();
            Integer z = scan.nextInt();
            //khắc phục lỗi định dạng dấu phân cách (dấu chấm, dấu phẩy) trong trình biên dịch số thực
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            double t = numberFormat.parse(scan.next().replace(",",".")).doubleValue();

            if (AS2_Main.choice == 9){
                myStack.push(new Product(x, y, z, t));
            }
            else {
                myQueue.push(new Product(x, y, z, t));
            }
        }
        System.out.printf(String.format("%-30s",ID) + String.format("%-30s",Title) + String.format("%-20s",Quantity) +
                String.format("%-20s",Price) + "\n" +
                "--------------------------------------------------------------------------------------\n");
        out.write("------------------------------------------\n\n" +
                String.format("%-30s",ID) + String.format("%-30s",Title) + String.format("%-20s",Quantity) +
                String.format("%-20s",Price) + "\n" +
                "--------------------------------------------------------------------------------------\n");
        scan.close();   //đóng file
    }

    public void ResetDataInMyStackMyQueue(){    //reset lại dữ liệu trong Stack và Queue
        if(AS2_Main.choice == 9 && AS2_Main.countMyStack > 0){
            myStack.clearData();
        }
        else if (AS2_Main.choice == 10 && AS2_Main.countMyQueue > 0){
            myQueue.clearData();
        }
    }
}