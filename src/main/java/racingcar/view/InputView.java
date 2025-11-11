package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return readInput();
    }

    public static int readGameCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
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
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private static void validatePositive(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("1 이상 입력해야 합니다.");
        }
    }
}
