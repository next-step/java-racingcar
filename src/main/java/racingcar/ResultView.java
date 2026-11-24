package racingcar;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String POSITION_MARK = "-";

    public static void viewResult(List<RoundResult> history) {
        System.out.println();
        System.out.println("실행 결과");
        for (RoundResult roundResult : history) {
            printRound(roundResult.getPositions());
        }
    }

    public static void viewWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private static void printRound(Map<String, Integer> positions) {
        for (Map.Entry<String, Integer> entry : positions.entrySet()) {
            System.out.println(entry.getKey() + " : " + POSITION_MARK.repeat(entry.getValue()));
        }
        System.out.println();
    }
}
