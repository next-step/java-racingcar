package racingcar.view;

import racingcar.Constant;
import racingcar.game.GameHistory;
import racingcar.strategy.PrintMarkStrategy;

import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private static final ResultView resultView = new ResultView();
    private final StringBuilder racingProgress = new StringBuilder();

    private ResultView() {
    }

    public static ResultView getInstance() {
        return resultView;
    }


    private void drawWithName(Map<String, Integer> carStatus, PrintMarkStrategy strategy) {
        carStatus.forEach((name, progress) -> {
            racingProgress.append(String.format("%s :", name));
            IntStream.range(0,progress).forEach(index->racingProgress.append(strategy.getPrintMark()));
            racingProgress.append(System.lineSeparator());
        });
        racingProgress.append(System.lineSeparator());

    }

    private void drawWinner(String winner) {
        racingProgress.append(winner)
                .append(Constant.SUFFIX_WINNER);
    }

    public void viewAll(GameHistory gameHistory, PrintMarkStrategy strategy) {
        clearRacingProgress();
        gameHistory.getHistoryAll().forEach((round, history)-> drawWithName(history,strategy));
        drawWinner(gameHistory.getWinner());
        System.out.println(racingProgress.toString());
    }

    private void clearRacingProgress(){
        if (racingProgress.length() > 0) {
            racingProgress.delete(0, racingProgress.length());
        }
    }
}
