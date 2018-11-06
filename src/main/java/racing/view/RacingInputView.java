package racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String NAME_SEPERATOR = ",";

    public static String[] inputTryNames(String message) {
        System.out.println(message);
        return splitNames(scanner.next());
    }

    private static String[] splitNames(String text) {
        return text.split(NAME_SEPERATOR);
    }

    public static int inputTryNo(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
