package racing.util;

import java.util.Scanner;

public class GameScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputNumber() {
        return scanner.nextInt();
    }

    public static String inputString() {
        return scanner.nextLine();
    }
}
