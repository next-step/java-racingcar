package calculator.util;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getLine() {
        return scanner.nextLine();
    }
}
