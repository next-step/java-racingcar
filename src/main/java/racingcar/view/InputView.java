package racingcar.view;

import racingcar.exception.ErrorMessage;

import java.util.Scanner;

public class InputView {

    private static final String NUM_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputNumOfCar() {
        return input(NUM_OF_CAR_MESSAGE);
    }

    public static int inputLoopCount() {
        return input(LOOP_COUNT_MESSAGE);
    }

    private static int input(String content) {
        System.out.println(content);
        int value = SCANNER.nextInt();
        validateInput(value);

        return value;
    }

    private static void validateInput(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
    }
}
