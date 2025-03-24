package racingcar.view;

import java.util.List;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String HYPHEN = "-";

    public static void printInitialState() {
        System.out.println(RESULT);
    }

    public static void printHyphens(List<Integer> counts) {
        counts.forEach(ResultView::printHyphens);
        System.out.println();
    }

    private static void printHyphens(int count) {
        System.out.println(HYPHEN.repeat(count));
    }
}
