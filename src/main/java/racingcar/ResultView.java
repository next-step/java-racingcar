package racingcar;

import java.util.List;

public class ResultView {

    private static final String POSITION_MARK = "-";

    public static void viewResult(List<RoundResult> history) {
        System.out.println();
        System.out.println("실행 결과");
        for (RoundResult roundResult : history) {
            printRound(roundResult.getPositions());
        }
    }

    private static void printRound(List<Integer> positions) {
        for (int position : positions) {
            System.out.println(POSITION_MARK.repeat(position));
        }
        System.out.println();
    }
}
