package racingcar.view;

import java.util.Collections;

public class ResultView {
    private static final String SCOREBOARD = "-";
    private static final String RESULT_PRINT = "실행 결과";

    public static void printPosition(int position) {
        System.out.println(String.join("", Collections.nCopies(position, SCOREBOARD)));
    }

    public static void printNewLine() {
        System.out.println("");
    }

    public static void printResult() {
        System.out.println(RESULT_PRINT);
    }
}
