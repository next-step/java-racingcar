package racingcar;

import java.text.MessageFormat;
import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void showRacingGameResult(List<RacingGameResultSet> racingGameResultSets) {
        System.out.println("\n실행결과");
        racingGameResultSets.forEach(ResultView::printRacingGameResultSet);

        RacingGameResultSet lastRacingGameResultSet = racingGameResultSets.get(racingGameResultSets.size() - 1);
        printWinnerRacingGameResult(lastRacingGameResultSet);
    }

    private static void printRacingGameResultSet(RacingGameResultSet racingGameResultSet) {
        racingGameResultSet.getRacingGameResults().forEach(ResultView::printRacingGameResult);
        System.out.println();
    }

    private static void printRacingGameResult(RacingGameResultSet.RacingGameResult racingGameResult) {
        String message = MessageFormat.format("{0}: {1}", racingGameResult.getName(), StringUtils.convertToHyphen(racingGameResult.getPosition()));
        System.out.println(message);
    }

    private static void printWinnerRacingGameResult(RacingGameResultSet racingGameResultSet) {
        String message = MessageFormat.format("{0}가 최종 우승했습니다.", racingGameResultSet.getRacingGameWinner());
        System.out.println(message);
    }
}
