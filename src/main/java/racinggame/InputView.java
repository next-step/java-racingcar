package racinggame;

import java.util.Scanner;

public final class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() { }

    public static int enterCarCount() {
        return enterInputValue("자동차 대수는 몇 대 인가요?");
    }

    public static int enterRound() {
        return enterInputValue("시도할 회수는 몇 회 인가요?");
    }

    private static int enterInputValue(String question) {
        System.out.println(question);
        int value = scanner.nextInt();

        validateInputValue(value);

        return value;
    }

    private static void validateInputValue(int value) {
        if (value <= 0) {
            throw new InputValueException();
        }
    }
}
