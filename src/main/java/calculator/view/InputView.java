package calculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString() {
        return sc.nextLine();
    }
}
