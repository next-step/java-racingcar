package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String MIN_COUNT_ERROR_MESSAGE = "최소 1이상의 숫자를 입력하셔야 합니다.";
    private static final int MIN_COUNT = 1;

    public InputView() {
    }

    public static int getCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return inputCountValue();
    }

    public static int getTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return inputCountValue();
    }

    private static int inputCountValue() {
        int value = scanner.nextInt();
        validateMinCount(value);
        return value;
    }

    private static void validateMinCount(int inputValue) {
        if (inputValue < MIN_COUNT) {
            throw new IllegalArgumentException(MIN_COUNT_ERROR_MESSAGE);
        }
    }
}
