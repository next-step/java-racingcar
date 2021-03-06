package racingcar.util;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DIGIT_REGEX = "\\d+";

    public static int getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String input = scanner.nextLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    public static int getNumberOfRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String input = scanner.nextLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    private static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException("입력한 " + input + "는 숫자가 아닙니다");
        }
    }

}
