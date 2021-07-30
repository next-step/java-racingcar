package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int receiveCarCount() {
        return receiveCount(MESSAGE_CAR_COUNT);
    }

    public static int receiveRoundCount() {
        return receiveCount(MESSAGE_ROUND_COUNT);
    }

    private static int receiveCount(String message) {
        String input;
        System.out.println(message);
        do {
            input = scanner.nextLine();
        } while (!isNumber(input));
        return Integer.parseInt(input);
    }

    private static boolean isNumber(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
