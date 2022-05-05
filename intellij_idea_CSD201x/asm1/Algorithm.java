package asm1;

import java.io.*;
import java.util.Scanner;

public class Algorithm {
    private int n;  //khai báo biến thuộc tính cho class
    private double[] a;
    public void input(Scanner sc) throws IOException {  //nhập dữ liệu và ghi vào fle
        File file = new File("INPUT.txt");  //khởi tạo file
        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream stream = new FileOutputStream(file);
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");

        System.out.print("nhập n: ");
        n = sc.nextInt();   //yêu cầu nhập số lượng phần tử(n)
        System.out.println("Nhập các phần tử của mảng: ");
        double x;   //khai báo biến
        for (int i = 0; i < n; i++){    //vòng lặp để nhập dữ liệu đầu vào
            System.out.printf("phần tử thứ %d: ", i+1);
            x = sc.nextDouble();    //yêu cầu người dùng nhập vào biến x
            out.write(String.valueOf(x) + "  ");    //ghi file
        }
        System.out.println("----------------------------------------");
        out.close();    //đóng file
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void ouput() throws IOException {    //đọc file INPUT.txt và lưu các giá trị trong file vào mảng
        File file = new File("INPUT.txt");        //khai báo file
        FileInputStream fileInputStream = new FileInputStream(file);

        a = new double[n];  //khởi tạo mảng a
        Scanner scan;   //gọi máy quét
        try {
            scan = new Scanner(file);   //sử dụng máy quét đọc file
            int i = 0;  //khai báo chỉ số ban đầu cho mảng
            while(scan.hasNextDouble()) //vòng lặp để đọc hết dữ liệu kiểu double có trong file
            {
                a[i] = scan.nextDouble();   //lưu dữ liệu đã đọc vào mảng
                i++;    //chỉ số tăng lên 1
            }

        } catch (FileNotFoundException e1) {    //bắt ngoại lệ(bắt lỗi và điều hướng cho chương trình một cách thích hợp)
            e1.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void showNumber(){   //phương thức hiển thị các phần tử của mảng a
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + "  ");
        }
        System.out.println("\n----------------------------------------");
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void BubbleSort() throws IOException {   //phương thức sắp xếp thuật toán Bubble Sort
        double[] b = a; //khởi tạo mảng b
        for (int j = 0; j <= n - 1; j++) { //vòng lặp điều kiện cho số bước sắp xếp
            int count = 0; //biến đếm xác định mảng đã sắp xếp xong cho điều kiện sau
            for (int i = 0; i < n - 1; i++) {   //vòng lặp để xét và hoán đổi các phần tử cần sắp xếp lại
                if (b[i] > b[i + 1]) {  //điều kiện để xảy ra sự hoán đổi
                    double save = b[i];     //biến save để lưu trữ giá trị
                    b[i] = b[i + 1];
                    b[i + 1] = save;
                    count++;
                }
            }

            if (count == 0) {   //ghi kết quả bước cuối cùng vào file
                File file = new File("OUTPUT1.TXT");    //khởi tạo file
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream stream = new FileOutputStream(file);
                OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");
                for (int i = 0; i < n; i++) {
                    out.write(String.valueOf(b[i]) + "  "); //ghi file
                }
                out.write("\n");
                out.close();    //đóng file
                break;
            }

            for (int i = 0; i < n; i++) {   //in kết quả sau mỗi bước
                System.out.print(b[i] + "  ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void SelectionSort() throws IOException {    //phương thức sắp xếp thuật toán Selection Sort
        double[] b = a; //khởi tạo mảng b
        for (int i = 0; i < n-1; i++) {   //vòng lặp cho số bước sắp xếp
            double min = b[i+1];    //khai báo biến min
            int t = i+1;    //biến t để lấy giá trị chỉ số của min trong dãy
            int count = 0;
            for (int j = i+1; j < n; j++) { //vòng lặp nhằm xác định giá trị nhỏ nhất của các số còn lại trong dãy
                // và chỉ số của nó
                if (min > b[j]) {
                    min = b[j];
                    t = j;
                } else continue;
            }
            if (b[i] > min) {       //điều kiện để hoán đổi xảy ra
                double save = b[i];
                b[i] = b[t];
                b[t] = save;
                count++;
            }
            //in kết quả ra màn hình
            if (count != 0) {        //điều kiện để tránh sự trùng lặp kết quả in ra ở mỗi bước
                for (int j = 0; j < n; j++) {
                    System.out.print(b[j] + "  ");
                }
                System.out.println();
            }
            if(i == n-2) {      //lưu bước cuối cùng vào file
                File file = new File("OUTPUT2.TXT");    //khởi tạo file
                if(!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream stream = new FileOutputStream(file);
                OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");
                for (int j = 0; j < n; j++){
                    out.write(b[j] + "  "); //ghi file
                }
                out.write("\n");
                out.close();    //đóng file
            }
        }
        System.out.println("----------------------------------------");
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void InsertionSort() throws IOException {        //phương thức sắp xếp thuật toán Insertion Sort
        double[] b = a; //khởi tạo mảng b
        for (int i = 0; i < n - 1; i++){    //vòng lặp cho số bước sắp xếp
            int count = 0;  //biến đếm để lấy điều kiện in ra màn hình cho các bước có sự hoán đổi
            int index = i + 1;  //biến lấy chỉ số cho phần tử được xét trong bước

            for (int j = i; j >= 0; j--){   //vòng lặp để so sánh và sắp xếp bằng cách hoán đổi giá trị
                double sort = b[index];     //khai báo và gán giá trị cho phần tử xét
                if(sort < b[j]){        //điều kiện để hoán đổi xảy ra
                    b[index] = b[j];
                    b[j] = sort;
                    count++;    //biến count tăng lên để xét cho điều kiện sau
                    index = j;  //lấy chỉ số hiện tại cho phần tử xét(sort)
                }
            }
            if (count != 0) {   //điều kiện để tránh sự trùng lặp kết quả in ra ở mỗi bước
                for (int j = 0; j < n; j++) {    //in giá trị sau mỗi bước
                    System.out.print(b[j] + "  ");
                }
                System.out.println();
            }
        }
        File file = new File("OUTPUT3.TXT");    //khởi tạo file
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(file);
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");
        for (int j = 0; j < n; j++){
            out.write(b[j] + "  ");
        }
        out.write("\n");
        out.close();    //đóng file ghi
        System.out.println("----------------------------------------");
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void LinearSearch(Scanner sc) throws IOException {   //phương thức tìm kiếm tuyến tính
        System.out.print("Nhập value = ");
        double value = sc.nextDouble();
        int count = 0;

        File file = new File("OUTPUT4.TXT");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(file);
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");
        for(int i = 0; i < a.length; i++){
            if(a[i] > value) {
                count++;
                System.out.println("Số " + a[i] + " tại vị trí " + i + " thỏa mãn điều kiện");
                out.write("Số " + a[i] + " ở vị trí " + i + " thỏa điều kiện\n");
            }
        }
        if (count == 0){
            System.out.println("Không một số nào trong dãy có giá trị lớn hơn value");
            out.write("Không có số nào thỏa mãn điều kiện");
        }
        out.close();
        System.out.println("----------------------------------------");
    }
    //----------------------------------------------------------------------------------------------------------------------
    public void BinarySearch(Scanner sc) throws IOException {   //phương thức tìm kiếm nhị phân
        File file = new File("OUTPUT1.txt");    //khai báo file input
        FileInputStream fileInputStream = new FileInputStream(file);

        double[] b = new double[n];  //khởi tạo mảng a
        Scanner scan;   //gọi máy quét
        try {
            scan = new Scanner(file);   //sử dụng máy quét đọc file
            int i = 0;  //khai báo chỉ số ban đầu cho mảng
            while(scan.hasNextDouble()) //vòng lặp để đọc hết dữ liệu kiểu double có trong file
            {
                b[i] = scan.nextDouble();   //lưu dữ liệu đã đọc vào mảng
                i++;    //chỉ số tăng lên 1
            }

        } catch (FileNotFoundException e1) {    //bắt ngoại lệ(bắt lỗi và điều hướng cho chương trình một cách thích hợp)
            e1.printStackTrace();
        }finally {      //kết thúc chương trình đọc
            fileInputStream.close();
        }

        File filesave = new File("OUTPUT5.TXT");    //khởi tạo file output
        if(!filesave.exists()){
            filesave.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(filesave);
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");

        System.out.print("Nhập value = ");
        double value = sc.nextDouble(); //lấy giá trị biến value

        int low = 0, hight = b.length-1;    //khai báo chỉ số trên và chỉ số dưới trong mảng xét
        do {        //vòng lặp do-while để tìm giá trị số bằng với value
            int t = low + (hight - low) / 2;    //biến t lấy chỉ số giữa cho dãy số được xét
            if (b[t] < value) {     //điều kiện để dịch chuyển chỉ số trên hoặc chỉ số dưới
                low = t + 1;
            } else if (b[t] > value) {
                hight = t - 1;
            } else {
                System.out.println("phần tử tại chỉ số " + t + " trong mảng có giá trị bằng value\n" +
                        "----------------------------------------");
                out.write("phần tử tại chỉ số " + t + " trong mảng có giá trị bằng value\n");   //ghi file
                break;
            }
        }while (low != hight);
        if (low == hight && b[low] != value){
            System.out.println("Mảng không tồn tại phần tử có giá trị bằng value!\n" +
                    "----------------------------------------");
            out.write("Mảng không tồn tại phần tử có giá trị bằng value!\n");   //ghi file
        }
        else if (low == hight && b[low] == value) {
            System.out.println("phần tử tại chỉ số " + low + " trong mảng có giá trị bằng value\n" +
                    "----------------------------------------");
            out.write("phần tử tại chỉ số " + low + " trong mảng có giá trị bằng value\n");//ghi file
        }
        out.close(); //đóng file
    }
}
