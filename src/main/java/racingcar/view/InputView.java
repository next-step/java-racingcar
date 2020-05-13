package racingcar.view;

import racingcar.exception.ErrorMessage;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int input(String content) {
        System.out.println(content);
        return validatedInput(SCANNER.nextInt());
    }

    private static int validatedInput(final int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
        return input;
    }
}
