package racingcar;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {

    }

    public static void showRacingGameResultSet(List<RacingGameResultSet> racingGameResultSets, List<RacingGameWinner> racingGameWinners) {
        System.out.println("\n실행결과");
        racingGameResultSets.forEach(ResultView::showRacingGameResult);
        showRacingGameWinner(racingGameWinners);
    }

    private static void showRacingGameResult(RacingGameResultSet racingGameResultSet) {
        racingGameResultSet.getRacingGameResults().forEach(ResultView::printResultMessage);
        System.out.println();
    }

    private static void printResultMessage(RacingGameResultSet.RacingGameResult racingGameResult) {
        String message = MessageFormat.format("{0}: {1}", racingGameResult.getName(), StringUtils.convertToHyphen(racingGameResult.getPosition()));
        System.out.println(message);
    }

    private static void showRacingGameWinner(List<RacingGameWinner> racingGameWinners) {
        String message = MessageFormat.format("{0}가 최종 우승했습니다.", racingGameWinners.stream().map(RacingGameWinner::getName).collect(Collectors.joining(", ")));
        System.out.println(message);
    }
}
