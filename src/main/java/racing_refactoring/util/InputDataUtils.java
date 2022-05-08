package racing_refactoring.util;

import java.util.Scanner;

public class InputDataUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private InputDataUtils() {
        throw new AssertionError();
    }

    public static String scan(String inputText) {
        System.out.println(inputText);
        return scanner.nextLine();
    }

    public static int scanNumber(String inputText) {
        System.out.println(inputText);
        return scanner.nextInt();
    }
}