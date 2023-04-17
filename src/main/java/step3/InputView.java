package step3;

import java.util.Scanner;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int askInteger(String message) {
        printMessage(message);
        return receiveInteger();
    }

    private static int receiveInteger() {
        return SCANNER.nextInt();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
