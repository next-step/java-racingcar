package racingcar.view;

import racingcar.Constant;
import racingcar.game.GameHistory;
import racingcar.strategy.PrintMarkStrategy;

import java.util.Map;

public class ResultView {
    private static final ResultView resultView = new ResultView();
    private final StringBuilder racingProgress = new StringBuilder();

    private ResultView() {
    }

    public static ResultView getInstance() {
        return resultView;
    }


    private void drawWithName(Map<String, Integer> carStatus, PrintMarkStrategy strategy) {
        carStatus.forEach((name, progress) -> racingProgress.append(String.format("%s :", name))
                .append(String.valueOf(strategy.getPrintMark()).repeat(Math.max(0, progress)))
                .append(System.lineSeparator()));
        racingProgress.append(System.lineSeparator());

    }

    private void drawWinner(String winner) {
        racingProgress.append(winner)
                .append(Constant.SUFFIX_WINNER);
    }

    public void viewAll(GameHistory gameHistory, PrintMarkStrategy strategy) {
        if (racingProgress.length() > 0) {
            racingProgress.delete(0, racingProgress.length());
        }
        gameHistory.getHistoryAll().forEach((round, history)-> drawWithName(history,strategy));
        drawWinner(gameHistory.getWinner());
        System.out.println(racingProgress.toString());
    }
}
