package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final int MIN_VALUE = 1;
    private static final String NUMBER_REGEX = "\\d+";
    private static final String NUMBER_ERROR = "숫자를 입력해야 합니다.";
    private static final String POSITIVE_ERROR = MIN_VALUE + " 이상 입력해야 합니다.";
    private static final String CAR_COUNT_PROMPT = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_PROMPT = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static int readCarCount() {
        System.out.println(CAR_COUNT_PROMPT);
        return readInput();
    }

    public static int readGameCount() {
        System.out.println(GAME_COUNT_PROMPT);
        return readInput();
    }

    private static int readInput() {
        String input = scanner.nextLine().trim();
        validateNumber(input);
        int number = Integer.parseInt(input);
        validatePositive(number);
        return number;
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    private static void validatePositive(int number) {
        if (number < MIN_VALUE) {
            throw new IllegalArgumentException(POSITIVE_ERROR);
        }
    }
}
