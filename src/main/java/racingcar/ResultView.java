package racingcar;

import java.util.List;

public class ResultView {

    private static final String POSITION_MARK = "-";

    public static void viewResult(List<List<Integer>> history) {
        System.out.println();
        System.out.println("실행 결과");
        for (List<Integer> positions : history) {
            printRound(positions);
        }
    }

    private static void printRound(List<Integer> positions) {
        for (int position : positions) {
            System.out.println(POSITION_MARK.repeat(position));
        }
        System.out.println();
    }
}
