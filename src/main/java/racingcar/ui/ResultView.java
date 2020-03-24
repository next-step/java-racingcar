package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarsIterator;
import racingcar.domain.RacingGameResults;

import java.util.Map;

import static racingcar.domain.RacingGameConstant.*;

public class ResultView {

    public ResultView() {
    }

    public void print(RacingGameResults racingGameResults) {
        System.out.printf(WINNER_COMMENT_PREFIX, renderGameResultsToView(racingGameResults));
    }

    public String renderGameResultsToView(RacingGameResults racingGameResults) {
        Map<Integer, Cars> gameResults = racingGameResults.getGameResultSet();
        StringBuilder collectResult = new StringBuilder();
        gameResults.entrySet()
                .stream()
                .forEach(e -> collectResult.append(getResults(e.getValue())));

        return collectResult
                .append(racingGameResults.getWinners())
                .append(WINNER_COMMENT_SUFFIX)
                .toString();
    }

    public String getResults(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();

        CarsIterator carsIterator = new CarsIterator(cars);
        while (carsIterator.hasNext()) {
            writeAllCarsPosition(stringBuilder, carsIterator.next());
        }
        stringBuilder.append(CARRIAGE_RETURN);

        return stringBuilder.toString();
    }

    private void writeAllCarsPosition(StringBuilder stringBuilder, Car car) {
        stringBuilder.append(car.getName().concat(COLON));
        for (int i = NUMBER_ZERO; i < car.getPosition(); i++) {
            stringBuilder.append(CAR_MARKER);
        }
        stringBuilder.append(CARRIAGE_RETURN);
    }
}
