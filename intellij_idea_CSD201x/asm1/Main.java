package asm1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Algorithm algorithm = new Algorithm();  //khai báo đối tượng

        Boolean logic = false;  //biến logic xét điều kiện cho vòng lặp do-while

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.Input\n" +
                    "2.Output\n" +
                    "3.Bubble sort\n" +
                    "4.Selection sort\n" +
                    "5.Insertion sort\n" +
                    "6.Search > value\n" +
                    "7.Search = value\n" +
                    "0.Exit\n");
            System.out.print("\nChoice: ");
            int choice = sc.nextInt();  //lựa chọn chức năng chương trình
            sc.nextLine();

            switch (choice){
                case 1:     //ghi dữ liệu vào file
                    algorithm.input(sc);
                    break;
                case 2:     //đọc dữ liệu từ file và lưu vào mảng, in ra màn hình các phần tử mảng
                    algorithm.ouput();
                    algorithm.showNumber();
                    break;
                case 3:     //sắp xếp theo thuật toán Bubble sort
                    algorithm.ouput();
                    long startTimeone = System.nanoTime();  //đặt mốc thời gian thực hiện thuật toán
                    algorithm.BubbleSort();
                    long endTimeone   = System.nanoTime();  //thời điểm hoàn thành thuật toán
                    long totalTimeone = endTimeone - startTimeone;  //thời gian thực hiện thuật toán
                    System.out.println("Thời gian thực hiện thuật toán:  " + totalTimeone + " ns");
                    break;
                case 4:     //sắp xếp theo thuật toán Selection sort
                    algorithm.ouput();
                    long startTimetwo = System.nanoTime();
                    algorithm.SelectionSort();
                    long endTimetwo   = System.nanoTime();
                    long totalTimetwo = endTimetwo - startTimetwo;
                    System.out.println("Thời gian thực hiện thuật toán:  " + totalTimetwo + " ns");
                    break;
                case 5:     //sắp xếp theo thuật toán Insertion sort
                    algorithm.ouput();
                    long startTimethree = System.nanoTime();
                    algorithm.InsertionSort();
                    long endTimethree   = System.nanoTime();
                    long totalTimethree = endTimethree - startTimethree;
                    System.out.println("Thời gian thực hiện thuật toán:  " + totalTimethree + " ns");
                    break;
                case 6:     //tìm kiếm tuyến tính
                    algorithm.ouput();
                    algorithm.LinearSearch(sc);
                    break;
                case 7:     //tìm kiếm nhị phân
                    algorithm.BinarySearch(sc);
                    break;
                default:        //thoát chương trình
                    logic = true;
                    sc.close();
                    break;
            }
        }while (logic == false);
    }
}
