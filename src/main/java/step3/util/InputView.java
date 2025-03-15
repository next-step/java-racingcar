package step3.util;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {}

    public static int inputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String inputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
