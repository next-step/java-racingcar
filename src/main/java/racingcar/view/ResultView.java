package racingcar.view;

import java.util.List;

import racingcar.utils.StringUtils;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String HYPHEN = "-";
    private static final String INFIX = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void print(String prefix, int count) {
        System.out.print(prefix);
        System.out.print(INFIX);
        printHyphens(count);
    }

    private static void printHyphens(int count) {
        System.out.println(HYPHEN.repeat(count));
    }

    public static void printSequence(int sequence) {
        if (sequence == 0) {
            System.out.println(RESULT);
            return;
        }
        System.out.printf("[ Race: %d ]%n", sequence);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(List<String> values) {
        System.out.println(StringUtils.joinByComma(values) + WINNER_MESSAGE);
    }
}
