package racingcar;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void showRacingGameResultSet(List<RacingGameResultSet> racingGameResultSets) {
        System.out.println("\n실행결과");
        racingGameResultSets.forEach(ResultView::showRacingGameResult);
    }

    private static void showRacingGameResult(RacingGameResultSet racingGameResultSet) {
        racingGameResultSet.getRacingGameResults().forEach(ResultView::printPosition);
        System.out.println();
    }

    private static void printPosition(RacingGameResultSet.RacingGameResult racingGameResult) {
        System.out.println(StringUtils.convertToHyphen(racingGameResult.getPosition()));
    }
}
