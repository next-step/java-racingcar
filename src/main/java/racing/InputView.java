package racing;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String ONLY_POSITIVE_VALID = "양수만 입력 가능합니다.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputRounds() {
        return inputPositive(ROUND_COUNT_TEXT);
    }

    private static int inputPositive(String question) {
        System.out.println(question);
        int value = scanner.nextInt();
        if (value < 1) { throw new RuntimeException(ONLY_POSITIVE_VALID); }

        return value;
    }

    public static String inputCarNames() {
        System.out.println(CAR_NAME_TEXT);
        return scanner.next();
    }
}
