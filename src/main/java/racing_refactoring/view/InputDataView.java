package racing_refactoring.view;

import java.util.Scanner;

public class InputDataView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputDataView() {
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