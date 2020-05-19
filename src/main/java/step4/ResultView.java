package step4;

import static step4.Constants.COMMA;
import static step4.Constants.POSITION_MARKER;
import static step4.Constants.RESULT_TITLE;
import static step4.Constants.RESULT_WINNER_MESSAGE;

import java.util.ArrayList;

public class ResultView {

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printCurrentResult(RacingGame racingGame) {
        ArrayList<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), makeCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    public String makeCarPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            stringBuilder.append(POSITION_MARKER);
        }
        return stringBuilder.toString();
    }

    public void printWinners(RacingGame racingGame) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String winner : racingGame.getWinners()) {
            stringBuilder = appendWinner(winner, stringBuilder);
        }
        System.out.printf(RESULT_WINNER_MESSAGE, stringBuilder.toString());
    }

    public StringBuilder appendWinner(String winner, StringBuilder winnerStringBuilder) {
        if (winnerStringBuilder == null) {
            winnerStringBuilder = new StringBuilder();
        }

        if (winnerStringBuilder.length() >= 1) {
            winnerStringBuilder.append(COMMA);
        }
        winnerStringBuilder.append(winner);
        return winnerStringBuilder;
    }
}
