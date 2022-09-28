package step4.input;

import java.util.Scanner;

public class RacingCarInput {

    public static String[] carNames() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(",");
    }

    public static int tryCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
