package racingcar.view;

import racingcar.exception.ErrorMessage;
import racingcar.util.StringUtil;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String NAME_ARRAY_OF_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUM_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final String DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputNameOfCars() {
        return inputArray(NAME_ARRAY_OF_CARS_MESSAGE);
    }

    public static int inputNumOfCar() {
        return input(NUM_OF_CAR_MESSAGE);
    }

    public static int inputLoopCount() {
        return input(LOOP_COUNT_MESSAGE);
    }

    private static String[] inputArray(final String message) {
        System.out.println(message);
        String value = SCANNER.nextLine();
        validateArrayValue(value);

        return Arrays.stream(value.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private static void validateArrayValue(final String value) {
        if (StringUtil.isEmpty(value)) {
            throw new IllegalArgumentException("aa");
        }
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
