package racingGame.view;

import racingGame.domain.car.Car;
import racingGame.domain.game.GameResult;
import racingGame.domain.participant.RoundScore;

import java.util.List;

public class ResultView {

    private static final String START_TEXT = "실행 결과\n";
    private static final String ENTER = "\n";
    private static final String POSITION_TEXT = "-";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";
    private static final String SEPARATOR = ",";

    private StringBuilder resultMessage = new StringBuilder(START_TEXT);


    public ResultView(GameResult gameResult) {
        gameResult.getRoundScores()
                .forEach(this::appendGameResult);
        appendWinner(gameResult.getWinners());
    }

    private void appendWinner(List<Car> winners) {
        winners.forEach(winner -> resultMessage.append(winner.getName())
                .append(SEPARATOR));
        resultMessage.deleteCharAt(resultMessage.length() - 1)
                .append(WINNER_TEXT);
    }

    private void appendGameResult(RoundScore roundScore) {
        roundScore.getRecords().
                forEach(carLog -> resultMessage
                        .append(carLog.getCarName())
                        .append(" : ")
                        .append(translatePositionText(carLog.getPosition()))
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

