package step3;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void newLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printEachResult(List<String> result) {
        for (String each : result) {
            System.out.println(each);
        }
        newLine();
    }

}