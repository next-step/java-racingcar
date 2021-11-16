package racingcar.utils;

import java.util.Scanner;

public class ScannerUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputInt() {
        return scanner.nextInt();
    }

    public static String getInputString() {
        return scanner.nextLine();
    }

}
