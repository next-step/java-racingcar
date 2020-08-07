package racingcar.ui;

import java.util.Scanner;

public class ScannerInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static int nextInt() {
        return scanner.nextInt();
    }
}
