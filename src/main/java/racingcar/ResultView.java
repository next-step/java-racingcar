package racingcar;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void showRacingGameResults(List<RacingGameResultSet> resultSets) {
        System.out.println("\n실행결과");
        resultSets.forEach(RacingGameResultSet::showPositions);
    }
}
