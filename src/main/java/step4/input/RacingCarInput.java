package step4.input;

import java.util.Scanner;

public class RacingCarInput {

    public static Integer carCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Integer tryCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
