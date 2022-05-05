package PRO192x.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeStudent {
    private static Integer weightMidterm;
    private static Integer weightFinal;
    private static Integer weightHomework;
    private static Double percentage1;
    private static Double percentage2;
    private static Double percentage3;

    public static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade.\n");
    }

    //điểm giữa kì
    public static Integer midTerm(Scanner sc){
        Integer score, shift, shiftAmount;

        System.out.print("Midterm:\nWeight (0-100)? ");
        do {
            weightMidterm = sc.nextInt();
            if(weightMidterm >= 100) System.out.print("Enter Weight: ");
        }while (weightMidterm >= 100);

        System.out.print("Score earned? ");
        score = sc.nextInt();

        System.out.print("Were scores shifted (1=yes, 2=no) ? ");
        shift = sc.nextInt();
        if(shift == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = sc.nextInt();
        }
        else shiftAmount = 0;

        if(score + shiftAmount > 100)  System.out.println("Total points = 100 / 100");
        else  System.out.println("Total points = " + (score + shiftAmount) + " / 100");

        if(score + shiftAmount > 100){
            percentage1 = (1.0)*weightMidterm;
            System.out.printf("Weighted score = %.1f / %d\n\n", percentage1, weightMidterm);
        }
        else {
            percentage1 = (1.0) * (score + shiftAmount) * weightMidterm / 100;
            System.out.printf("Weighted score = %.1f / %d\n\n", percentage1, weightMidterm);
        }
            return weightMidterm;//giá trị trả về
    }

    //điểm cuối kì
    public static Integer finalTerm(Scanner sc){
        Integer score, shift, shiftAmount;

        System.out.print("Final:\nWeight (0-100)? ");
        do{
            weightFinal = sc.nextInt();
            if(weightMidterm + weightFinal >= 100) System.out.print("Enter Weight: ");
        }while (weightFinal + weightMidterm >= 100);

        System.out.print("Score earned? ");
        score = sc.nextInt();

        System.out.print("Were scores shifted (1=yes, 2=no) ? ");
        shift = sc.nextInt();
        if(shift == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = sc.nextInt();
        }
        else shiftAmount = 0;

        if(score + shiftAmount > 100)  System.out.println("Total points = 100 / 100");
        else  System.out.println("Total points = " + (score + shiftAmount) + " / 100");

        if(score + shiftAmount > 100) {
            percentage2 = (1.0)*weightFinal;
            System.out.printf("Weighted score = %.1f / %d\n\n", percentage2, weightFinal);
        }
        else {
            percentage2 = (1.0) * (score + shiftAmount) * weightFinal / 100;
            System.out.printf("Weighted score = %.1f / %d\n\n", percentage2, weightFinal);
        }
        return weightFinal;//giá trị trả về
    }

    //bài tập về nhà
    public static Integer homework(Scanner sc){
        Integer assignment, section;
        Integer point = 0, total = 0;

        System.out.print("Homework:\nWeight (0-100)? ");
        do{
            weightHomework = sc.nextInt();
            if(weightMidterm + weightFinal + weightHomework != 100) System.out.print("Enter Weight: ");
        }while (weightFinal + weightMidterm + weightHomework != 100);

        System.out.print("Number of assignments? ");
        assignment = sc.nextInt();

        ArrayList<Integer> listAsm = new ArrayList<Integer>();

            for (int i = 1; i <= assignment; i++) {
                Integer scoreAsm = 0, maxAsm = 0;
                System.out.print("Assignment " + i + " score and max? ");
                scoreAsm = sc.nextInt();
                maxAsm = sc.nextInt();
                listAsm.add(scoreAsm);
                listAsm.add(maxAsm);
            }

            System.out.print("How many sections did you attend? ");
            section = sc.nextInt();

            if (section * 5 > 30) {
                section = 6;
                System.out.println("Section points = 30 / 30");
            }
            else System.out.println("Section points = " + section * 5 + " / 30");

            for (int i = 0; i < 2*assignment; i++) {
                if (i % 2 == 0) point += listAsm.get(i);
                else total += listAsm.get(i);
            }

            if (total > 150) {
               total = 150;
                if(point > 150) {
                    point = 150;
                    System.out.println("Total points = " + (point + section * 5) + " / 180");
                }
                else  System.out.println("Total points = " + (point + section * 5) + " / 180");
            }
            else  System.out.println("Total points = " + (point + section * 5) + " / " + (total + 30));

        percentage3 = (1.0)*(point + section*5)*weightHomework/(total + 30);
        System.out.printf("Weighted score = %.1f / %d \n\n", percentage3, weightHomework);
        return weightHomework;//giá trị trả về
    }

    public static void report(){
        System.out.printf("Overall percentage = %.1f\n", (percentage1 + percentage2 + percentage3));

        if(percentage1 + percentage2 + percentage3 >= 85) {
            System.out.println("Your grade will be at least: 3.0");
            System.out.println("Graded Good!");

        }
        else if(percentage1 + percentage2 + percentage3 >= 75) {
            System.out.println("Your grade will be at least: 2.0");
            System.out.println("Graded Pretty!");
        }
        else if(percentage1 + percentage2 + percentage3 >= 60) {
            System.out.println("Your grade will be at least: 1.0");
            System.out.println("Graded Medium!");
        }
        else {
            System.out.println("Your grade will be at least: 0.0");
            System.out.println("Graded Weak");
        }
    }
}
