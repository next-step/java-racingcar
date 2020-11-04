package step3.view;

import java.util.List;

/**
 * Created By mand2 on 2020-11-04.
 * 출력판
 */
public class ResultView {

    private final static String DASH = "-";
    private final static String COMMAND_LINE_RESULT_MESSAGE = "실행 결과";


    public static void printResultMessage() {
        System.out.println(COMMAND_LINE_RESULT_MESSAGE);
    }

    public static void printResult(List<Integer> score) {
        score.forEach(c -> {
            printDash(c);
            System.out.println();
        });
    }

    private static void printDash(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print(DASH);
        }
    }

}
