package calculator;

import java.util.Scanner;

public class ConsoleView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void showResult(int result) {
        System.out.println(result);
    }
}
