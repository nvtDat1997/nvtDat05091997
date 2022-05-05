package PRO192x.basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GradeStudent.begin();
        GradeStudent.midTerm(sc);
        GradeStudent.finalTerm(sc);
        GradeStudent.homework(sc);
        GradeStudent.report();

    }
}
