package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

import racingcar.util.ErrorMessage;

public class InputView {
    public static final String NUM_OF_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final int MIN_INPUT_LOOP_COUNT = 0;
    private static final String COMMA = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputNameOfCars() {
        return getNameOfCars();
    }

    private static String[] getNameOfCars() {
        System.out.println(InputView.NUM_OF_NAME_MESSAGE);
        String inputNameOfCars = SCANNER.next();
        return splitNameOfCars(inputNameOfCars);
    }

    static String[] splitNameOfCars(String inputNameOfCars) {
        return Arrays.stream(inputNameOfCars.split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int inputLoopCount() {
        System.out.println(LOOP_COUNT_MESSAGE);
        int value = SCANNER.nextInt();
        validateLoopCountNumber(value);
        return value;
    }

    static void validateLoopCountNumber(int inputNumber) {
        if (isValidLoopCountNumber(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
    }

    static boolean isValidLoopCountNumber(int inputLoopCountNumber) {
        return inputLoopCountNumber <= MIN_INPUT_LOOP_COUNT;
    }
}
