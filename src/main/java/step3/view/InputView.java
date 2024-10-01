package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_COUNT = 1;
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String MIN_COUNT_ERROR_MESSAGE = "최소 " + MIN_COUNT + "이상의 숫자를 입력하셔야 합니다.";
    private static final String INCORRECT_TYPE_ERROR_MESSAGE = "숫자만 입력가능합니다.";

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return inputCarNames();
    }

    public static int getTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return inputCountValue();
    }

    private static String inputCarNames() {
        return SCANNER.nextLine();
    }

    private static int inputCountValue() {
        try {
            String inputValue = SCANNER.nextLine();
            int value = Integer.parseInt(inputValue);
            validateMinCount(value);
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INCORRECT_TYPE_ERROR_MESSAGE);
        }
    }

    private static void validateMinCount(final int inputValue) {
        if (inputValue < MIN_COUNT) {
            throw new IllegalArgumentException(MIN_COUNT_ERROR_MESSAGE);
        }
    }
}
