package racingcar.ui;

import racingcar.ui.model.InputValue;

import java.util.Scanner;

public class InputView implements Input {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_RETRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public InputValue input() {
        int carCount = input(INPUT_CAR_COUNT_MESSAGE);
        int retryCount = input(INPUT_RETRY_COUNT_MESSAGE);
        return InputValue.of(carCount, retryCount);
    }

    private int input(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}