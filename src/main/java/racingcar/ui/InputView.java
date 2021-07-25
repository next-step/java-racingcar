package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static int getInputCarCount() {
        System.out.println(MESSAGE_INPUT_CAR_COUNT);
        return getInput();
    }

    public static int getInputTryCount() {
        System.out.println(MESSAGE_INPUT_TRY_COUNT);
        return getInput();
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

}
