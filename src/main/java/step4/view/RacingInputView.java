package step4.view;

import java.util.Scanner;

import static step4.util.MyPrinter.printLine;

public class RacingInputView {
    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private RacingInputView() {
    }

    public static int carCount() {
        printLine(CAR_COUNT_QUESTION);
        return parseAnswerAndValidate();
    }

    public static String carNames() {
        printLine(CAR_NAMES_QUESTION);
        return SCANNER.nextLine();
    }

    public static int tryCount() {
        printLine(TRY_COUNT_QUESTION);
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
