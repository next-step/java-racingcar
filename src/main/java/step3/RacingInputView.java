package step3;

import java.util.Scanner;

public class RacingInputView {
    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private RacingInputView() {
    }

    public static int carCount() {
        System.out.println(CAR_COUNT_QUESTION);
        return parseAnswerAndValidate();
    }

    public static int tryCount() {
        System.out.println(TRY_COUNT_QUESTION);
        return parseAnswerAndValidate();
    }

    private static int parseAnswerAndValidate() {
        final int input = SCANNER.nextInt();

        assertPositive(input);

        return input;
    }

    private static void assertPositive(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("0 이상의 값을 입력해주세요.");
        }
    }

}
