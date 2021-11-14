package study.racing.utils;

import java.util.Scanner;

public final class ScannerUtils {

    private static final Scanner scanner = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static int nextInt() {
        return scanner.nextInt();
    }
}
