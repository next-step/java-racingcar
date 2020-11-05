package step5.view;

import step5.Constant;
import step5.controller.game.GameHistory;
import step5.strategy.PrintMarkStrategy;

import java.util.Map;
import java.util.stream.IntStream;

public class RacingResultView implements ResultView{
    private static final RacingResultView resultView = new RacingResultView();
    private final StringBuilder racingProgress = new StringBuilder();

    private RacingResultView() {
    }

    public static RacingResultView getInstance() {
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

    private void clearRacingProgress(){
        if (racingProgress.length() > 0) {
            racingProgress.delete(0, racingProgress.length());
        }
    }

    @Override
    public void render(GameHistory gameHistory, PrintMarkStrategy strategy) {
        clearRacingProgress();
        gameHistory.getHistoryAll().forEach((round, history)-> drawWithName(history,strategy));
        drawWinner(gameHistory.getWinner());
        System.out.println(racingProgress.toString());
    }
}
