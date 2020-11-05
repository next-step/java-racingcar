package racingcar.view;

import java.util.Scanner;

import racingcar.util.ErrorMessage;

public class InputView {
    public static final String NUM_OF_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final int MIN_INPUT_VALUE = 0;

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputNameOfCars() {
        return getNameOfCars(NUM_OF_NAME_MESSAGE);
    }

    public static int inputLoopCount() {
        return getLoopCount(LOOP_COUNT_MESSAGE);
    }

    private static int input(String content) {
        System.out.println(content);
        int value = SCANNER.nextInt();
        validateInputNum(value);
        return value;
    }

    static void validateInputNum(final int inputNumber) {
        if (isValidInputNumber(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
    }

    static boolean isValidInputNumber(int inputNumber) {
        return inputNumber <= MIN_INPUT_VALUE;
    }
}
