package study.car.race;

import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner scanner = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static int nextInt() {
        return scanner.nextInt();
    }
}
