package step5.racingcar.view;

import step5.racingcar.domain.Message;
import step5.racingcar.domain.RacingGame;

import java.util.List;

public class ResultView {

    private static final String POSITION_MARK = "-";
    private static final String DELIMITER = " : ";
    private static final String COMMA = ", ";
    private static final int INDEX_ZERO = 0;

    public void printResultHeader(String headerMessage) {
        System.out.println(headerMessage);
    }

    public void printResult(RacingGame racingGame) {
        List<String> carNames = racingGame.getPlayerCars().getCarNames();
        List<Integer> carPositions = racingGame.getPlayerCars().getCarPositions();
        int carCounts = carNames.size();
        for (int i = INDEX_ZERO; i < carCounts; i++) {
            System.out.print(carNames.get(i) + DELIMITER);
            printCurrentPosition(carPositions.get(i));
        }
        System.out.println();
    }

    private void printCurrentPosition(int currentPosition) {
        for (int i = INDEX_ZERO; i < currentPosition; i++) {
            System.out.print(POSITION_MARK);
        }
        System.out.println();
    }

    public void printWinnerCarNames(RacingGame racingGame) {
        List<String> winnerCarNames = racingGame.getPlayerCars().getWinnerCarNames();
        StringBuilder stringBuilder = new StringBuilder();
        for (String winnerCarName : winnerCarNames) {
            appendComma(stringBuilder);
            stringBuilder.append(winnerCarName);
        }
        System.out.println(stringBuilder.toString() + Message.RESULT_FOOTER);
    }

    private void appendComma(StringBuilder stringBuilder) {
        if (stringBuilder.length() > INDEX_ZERO)
            stringBuilder.append(COMMA);
    }
}
