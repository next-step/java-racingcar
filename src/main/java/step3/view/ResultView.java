package step3.view;

import java.util.List;

/**
 * Created By mand2 on 2020-11-04.
 * 출력판
 */
public class ResultView {

    private final static String DASH = "-";
    private final static String COMMAND_LINE_RESULT_MESSAGE = "실행 결과";

    public static void printResult(List<Integer> score, int cars) {
        printResultMessage();
        for (int i = 0; i < score.size(); i++) {
            splitRounds(i, cars);
            printDash(score.get(i));
        }
    }

    private static void splitRounds(int idx, int cars) {
        if (idx % cars == 0) {
            System.out.println();
        }
    }

    private static void printResultMessage() {
        System.out.println(COMMAND_LINE_RESULT_MESSAGE);
    }


    private static void printDash(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print(DASH);
        }

        System.out.println();
    }

}
