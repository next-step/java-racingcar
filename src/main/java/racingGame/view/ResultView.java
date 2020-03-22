package racingGame.view;

import racingGame.car.Car;
import racingGame.game.GameResult;
import racingGame.game.TotalGameResult;

import java.util.List;

public class ResultView {

    private static final String START_TEXT = "실행 결과\n";
    private static final String ENTER = "\n";
    private static final String POSITION_TEXT = "-";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";
    private static final String SEPARATOR = ",";

    private StringBuilder resultMessage = new StringBuilder(START_TEXT);


    public ResultView(TotalGameResult totalGameResult) {
        totalGameResult.getGameResults()
                .forEach(this::appendGameResult);
        appendWinner(totalGameResult.getWinners());
    }

    private void appendWinner(List<Car> winners) {
        winners.forEach(winner -> resultMessage.append(winner.getName())
                .append(SEPARATOR));
        resultMessage.deleteCharAt(resultMessage.length() - 1)
                .append(WINNER_TEXT);
    }

    private void appendGameResult(GameResult gameResult) {
        gameResult.getRecords().
                forEach(record -> resultMessage
                        .append(record.getCar().getName())
                        .append(" : ")
                        .append(translatePositionText(record.getDistance()))
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

