package racingGame.view;

import racingGame.game.GameResult;
import racingGame.game.TotalGameResult;

public class ResultView {

    private static final String START_TEXT = "실행 결과\n";
    private static final String ENTER = "\n";
    private static final String POSITION_TEXT = "-";

    private StringBuilder resultMessage = new StringBuilder(START_TEXT);


    public ResultView(TotalGameResult totalGameResult) {
        totalGameResult.getGameResults()
                .forEach(this::analyzeGameResult);
    }

    private void analyzeGameResult(GameResult gameResult) {
        gameResult.getPositions().
                forEach(position -> resultMessage
                        .append(translatePositionText(position))
                        .append(ENTER));
        resultMessage.append(ENTER);
    }

    private String translatePositionText(Integer position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_TEXT);
        }
        return builder.toString();
    }

    public void print() {
        System.out.print(resultMessage.toString());
    }
}

