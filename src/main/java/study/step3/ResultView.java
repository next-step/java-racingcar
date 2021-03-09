package study.step3;

import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = "\n";

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }
}
