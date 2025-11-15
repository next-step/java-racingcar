package racinggame.ui;

import static java.lang.Integer.parseInt;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt() {
        String input = SCANNER.nextLine();

        validBlank(input);

        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }

        return parseInt(input);
    }

    public static String inputString() {
        String input = SCANNER.nextLine();

        validBlank(input);

        return input;
    }

    private static void validBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 빈값 입니다.");
        }
    }
}
