package racingcar.util;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DIGIT_REGEX = "\\d+";
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = SCANNER.nextLine();
        validateNames(input);
        return input.split(DELIMITER);
    }

    private static void validateNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException("이름을 입력해 주세요");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해 주세요");
        }

    }

    public static int getNumberOfRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String input = SCANNER.nextLine();
        validateNumberOfRound(input);
        return Integer.parseInt(input);
    }

    private static void validateNumberOfRound(String input) {
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
