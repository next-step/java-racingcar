package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String NUMBER_OF_CARS_PROMPT = "자동차 대수는 몇 대 인가요?";
    private static final String RACING_TIMES_PROMPT = "시도할 회수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int inputNumberOfCars() {
        System.out.println(NUMBER_OF_CARS_PROMPT);
        return validateInputValue(SCANNER.nextInt());
    }

    public static int inputNumberOfAttempts() {
        System.out.println(RACING_TIMES_PROMPT);
        return SCANNER.nextInt();
    }

    public static int validateInputValue(int value) {
        if (value <= 0) {
            throw new IllegalStateException("자동차는 1대 이상 입력되어야 합니다.");
        }

        return value;
    }
}
