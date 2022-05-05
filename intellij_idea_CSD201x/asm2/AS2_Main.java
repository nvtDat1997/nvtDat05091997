package asm2;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AS2_Main  {

    static Integer choice;  //khai báo biến tĩnh cho class main, biến choice xác định chức năng mà người dùng muốn thực hiện
    static Integer countMyStack = 0;    //biến đếm cho số lần thực hiện sao lưu và in dữ liệu trong Stack ra màn hình
    static Integer countMyQueue = 0;    //biến đếm cho số lần thực hiện sao lưu và in dữ liệu trong Queue ra màn hình
    public static void main(String[] args) throws IOException, ParseException {
        creatNewFile(); //tạo một file sẵn để đưa dữ liệu vào bài toán

        OperationToProduct operationToProduct = new OperationToProduct();   //Khai báo đối tượng
        ArrayList<Integer> listIntegers = new ArrayList<>();    //khởi tạo danh sách số nguyên mới để sử dụng cho chức năng số 8

        //reset lại file console_output.txt mỗi khi chạy lại chương trình
        File file = new File("console_output.txt");  //khởi tạo file
        if(!file.exists()){     //nếu file chưa tồn tại thì chuyển đến tạo file mới
            file.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(file);   //Tạo đối tượng luồng và liên kết với nguồn dữ liệu
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");
        out.write("");  //reset file (file dành cho Stack với Queue)

        Boolean checkExit = false;  //Biến logic để xét điều kiện kết thúc chương trình khi người dùng muốn
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("----------------------\nProduct list:\n" +
                    "1. Load data from file and display\n" +
                    "2. Input & add to the end.\n" +
                    "3.Display data\n" +
                    "4.Save product list to file.\n" +
                    "5. Search by ID\n" +
                    "6.Delete by ID\n" +
                    "7.Sort by ID.\n" +
                    "8. Convert to Binary \n" +
                    "9. Load to stack and display\n" +
                    "10. Load to queue and display.\n" +
                    "Exit:\n" +
                    "0. Exit");
            System.out.print("\nNhập chức năng bạn muốn thực hiện:\n\tChoice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: //đọc dữ liệu từ file và lưu vào phía đuôi của danh sách móc nối
                    operationToProduct.readFileSaveDataInMylist();
                    break;
                case 2: //thêm một phần tử vào cuối danh sách
                    operationToProduct.inputAddLast(sc);
                    break;
                case 3: //duyệt từng phần tử của danh sách và hiển thị ra màn hình
                    operationToProduct.show(out);
                    break;
                case 4: //lưu dữ liệu từ danh sách móc nối vào file
                    operationToProduct.SaveDataInFile(out);
                    break;
                case 5: //Tìm thông tin sản phẩm theo mã
                    operationToProduct.findProductById(out, sc);
                    break;
                case 6: //Xóa sản phẩm ra khỏi danh sách móc nối theo mã
                    operationToProduct.deleteById(out, sc);
                    break;
                case 7: //Sắp xếp sản phẩm trong danh sách móc nối theo mã của sản phẩm theo thứ tự trong từ điển
                    operationToProduct.InsertionSortData(out);
                    break;
                case 8: //Hiển thì số lượng của sản phẩm đầu tiên trong danh sách theo hệ nhị phân
                    operationToProduct.displayBinary(out, operationToProduct.value(), listIntegers);
                    break;
                case 9: //xuất các sản phẩm có trong file đã tạo lưu vào Stack và hiển thị chúng
                    operationToProduct.ResetDataInMyStackMyQueue();     //reset lại Stack với mỗi lần gọi lại
                    operationToProduct.readFileSaveDataInMyStackAndMyQueue(out);    //đọc file và lưu dữ liệu vào Stack
                    operationToProduct.show(out);   //hiển thị Stack ra màn hình
                    countMyStack++; //biến đếm tăng lên với mỗi lần gọi
                    break;
                case 10:    //xuất các sản phẩm có trong file đã tạo lưu vào Queue và hiển thị chúng
                    operationToProduct.ResetDataInMyStackMyQueue();   //reset lại Queue với mỗi lần gọi lại
                    operationToProduct.readFileSaveDataInMyStackAndMyQueue(out);    //đọc file và lưu dữ liệu vào Queue
                    operationToProduct.show(out);   //hiển thị Queue ra màn hình
                    countMyQueue++; //biến đếm tăng lên với mỗi lần gọi
                    break;
                default:    //các giá trị Integer khác sẽ trả về true cho checkExit để kết thúc chương trình
                    checkExit = true;
                    break;
            }
        }while (checkExit != true);
        out.close();    //đóng file (file sẽ hiển thị dữ liệu output sau khi đóng)
    }

    //hàm tạo file sẵn để đưa vào sử dụng cho bài toán
    public static void creatNewFile() throws IOException{
        File file = new File("Data.txt");  //khởi tạo file
        if(!file.exists()){     //nếu file chưa tồn tại thì tạo mới
            file.createNewFile();
        }

        FileOutputStream stream = new FileOutputStream(file);   //Tạo đối tượng luồng và liên kết với nguồn dữ liệu
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");

        out.write("5 book 9 3,25\n" + "P05 notebook 12 4,15\n" + "ASM25 bag 10 3.5\n" +
                "P15 seat 7 7.5\n" + "ASBT table 8 13.25\n");     //ghi dữ liệu vào file
        out.close();    //đóng luồng
    }
}
