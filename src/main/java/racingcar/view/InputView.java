package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String NAME_OF_THE_CARS_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)을 기준으로 구분).";
    private static final String RACING_TIMES_PROMPT = "시도할 회수는 몇 회 인가요?";
    private static final String BASIC_SPLIT_REGEX = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String[] inputNumberOfCars() {
        System.out.println(NAME_OF_THE_CARS_PROMPT);
        String[] carNames = separateInputCars(SCANNER.nextLine());

        validateInputValue(carNames);

        return carNames;
    }

    public static int inputNumberOfAttempts() {
        System.out.println(RACING_TIMES_PROMPT);
        return SCANNER.nextInt();
    }

    public static String[] separateInputCars(String value) {
        return value.split(BASIC_SPLIT_REGEX);
    }

    public static void validateInputValue(String[] values) {
        checkTheNumberOfInputCars(values.length);
        for (String value : values) {
            checkLengthCarName(value);
        }
    }

    public static void checkTheNumberOfInputCars(int value) {
        if (value <= 0) {
            throw new IllegalStateException("자동차는 1대 이상 입력되어야 합니다.");
        }
    }

    public static void checkLengthCarName(String value) {
        if(value.length() > 5) {
            throw new IllegalStateException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
