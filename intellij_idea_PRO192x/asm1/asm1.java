package test2;

import java.util.Locale;
import java.util.Scanner;       //import gói thư viện java.util.Scanner
import java.util.Random;        //import gói thư viện java.util.Random

public class asm1 {     //khởi tạo class
    public static void main(String[] args) {        //phương thức main
        final Integer MAX = 100;     //Khai báo hằng
        final Integer MIN = 1;     //Khai báo hằng
        Integer yourNumber, sumcount = 0, n = 0;        //Khai báo biến
        Integer bestgame = Integer.MAX_VALUE;       //Đặt biến bằng với giá trị Integer lớn nhất
        String reply = "";      //Khai báo biến kiểu chuỗi với giá trị trống

        Scanner sc = new Scanner(System.in);        //Tạo mới 1 đối tượng Scanner sử dụng từ khóa new
        Random rd = new Random();       //Tạo mới 1 đối tượng Random sử dụng từ khóa new

        do {        //vòng lặp do-while để lặp lại chương trình khi người chơi muốn chơi lại
            Integer luckyNumber = rd.nextInt(MAX - MIN + 1) + MIN;   //Khai báo và gán giá trị cho luckyNumber
                                                                            //luckyNumber nằm trong khoảng MIN đến MAX
            Integer count = 0;      //Khai báo biến đếm để lấy giá trị bestgame và trả về thành tích cho người chơi
            System.out.print("Enter a number in 1-100: \n");
            n++;   //biến n đếm số lần chơi
            do {        //vòng lặp do-while để người chơi có thể tìm ra luckyNumber
                System.out.print("Your guess? ");
                yourNumber = sc.nextInt();      //cho phép người chơi nhập vào số dự đoán
                count++;
                if (yourNumber > luckyNumber) System.out.println("It's lower!"); //Thông báo cho người chơi biết luckyNumber
                if (yourNumber < luckyNumber) System.out.println("It's higher!");   // cao hơn hay thấp hơn số dự đoán
            } while (yourNumber != luckyNumber); //vòng lặp dừng lại khi người chơi đoán đúng được luckyNumber

            if(count < bestgame) bestgame = count;  //biến bestgame sẽ nhận và trả về giá trị số lần đoán ít nhất
                                                    // của 1 trong tất cả các lần chơi của người chơi
            sumcount += count;  //biến sumcount để đếm tổng số lần đoán của người chơi trong tất cả các cuộc chơi
            System.out.printf("You got it right in %d guesses!", count);
            System.out.print("\nDo you want to play again? ");
            reply = sc.next();  //lấy ý kiến người chơi có muốn chơi tiếp hay không
            reply = reply.toUpperCase();

        }while (reply.equals("Y") || reply.equals("YES"));
        //xét điều kiện cho câu trả lời của người chơi có tiếp tục chơi hay dừng lại

        System.out.printf("Overall results:\nTotal games\t\t=  %d\nTotal guesses\t=  %d\nGuesses/game\t=  %.1f\nBest game\t\t=  %d",
                n, sumcount, ((float)sumcount)/n, bestgame);    //in ra thành tích của người chơi sau khi dừng cuộc chơi
    }
}
