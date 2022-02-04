package racing.view;

import java.util.List;
import racing.domain.RoundResult;

public class ResultView {

    public static void printResult(List<RoundResult> results) {
        System.out.println("실행 결과");
        for (RoundResult result : results) {
            System.out.println(result.getStringResult());
        }
    }

    public static void printWinners(List<String> judgeWinner) {
        System.out.println("최종 우승자: " + String.join(", ", judgeWinner));
    }
}
