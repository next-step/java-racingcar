package racingcar;

import java.text.MessageFormat;
import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void showRacingGameResultSet(List<RacingGameResultSet> racingGameResultSets) {
        System.out.println("\n실행결과");
        racingGameResultSets.forEach(ResultView::showRacingGameResult);
    }

    private static void showRacingGameResult(RacingGameResultSet racingGameResultSet) {
        racingGameResultSet.getRacingGameResults().forEach(ResultView::printResultMessage);
        System.out.println();
    }

    private static void printResultMessage(RacingGameResultSet.RacingGameResult racingGameResult) {
        String message = MessageFormat.format("{0}: {1}", racingGameResult.getName(), StringUtils.convertToHyphen(racingGameResult.getPosition()));
        System.out.println(message);
    }
}
