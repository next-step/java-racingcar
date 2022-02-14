package racingcar.view;

import java.util.List;
import racingcar.domain.RacingResult;
import racingcar.domain.RacingTotalResult;

public class ResultView {

    public static void printGameStatus() {
        List<RacingResult> racingResults = RacingTotalResult.getRacingResults();
        racingResults.forEach(result -> {
            String dashes = getDashByMove(result.getMovingDistance());
            System.out.println(result.getCarName() + ":" + dashes);
        });
    }

    public static void printGameResult(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    public static void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    private static String getDashByMove(int move) {
        StringBuilder dash = new StringBuilder();

        for (int i = 0; i < move; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
