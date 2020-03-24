package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarsIterator;
import racingcar.domain.RacingGameResultsDto;

import java.util.Map;

import static racingcar.domain.RacingGameConstant.*;

public class ResultView {

    public ResultView() {
    }

    public void print(RacingGameResultsDto racingGameResultsDto) {
        System.out.printf(WINNER_COMMENT_PREFIX, renderGameResultsToView(racingGameResultsDto));
    }

    public String renderGameResultsToView(RacingGameResultsDto racingGameResultsDto) {
        Map<Integer, Cars> gameResults = racingGameResultsDto.get();
        StringBuilder collectResult = new StringBuilder();
        gameResults.entrySet()
                .stream()
                .forEach(e -> collectResult.append(getResults(e.getValue())));

        return collectResult
                .append(racingGameResultsDto.getWinners())
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
