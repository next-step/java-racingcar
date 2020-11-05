package racingcar.view;

import java.util.Scanner;

import racingcar.util.ErrorMessage;

public class InputView {
    public static final String NUM_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final int MIN_INPUT_VALUE = 0;

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputNumOfCar() {
        return input(NUM_OF_CAR_MESSAGE);
    }

    public static int inputLoopCount() {
        return input(LOOP_COUNT_MESSAGE);
    }

    public static int input(String content) {
        System.out.println(content);
        int value = SCANNER.nextInt();
        validateInputNum(value);

        return value;
    }

    public static void validateInputNum(final int inputNumber) {
        if (isValidInputNumber(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
    }

    public static boolean isValidInputNumber(int inputNumber) {
        return inputNumber <= MIN_INPUT_VALUE;
    }
}
