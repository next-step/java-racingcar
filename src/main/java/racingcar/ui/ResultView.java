package racingcar.ui;

import racingcar.domain.*;

public class ResultView {

    public ResultView() {
    }

    public void print(RacingGameResults racingGameResults) {
        System.out.printf(RacingGameConstant.WINNER_COMMENT_PREFIX, renderGameResultsToView(racingGameResults));
    }

    public String renderGameResultsToView(RacingGameResults racingGameResults) {
        StringBuilder collectResult = new StringBuilder();
        racingGameResults.getGameResultSet()
                .stream()
                .forEach(e -> collectResult.append(getResults(e.getValue())));

        return collectResult
                .append(racingGameResults.getWinners())
                .append(RacingGameConstant.WINNER_COMMENT_SUFFIX)
                .toString();
    }

    public String getResults(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();

        CarsIterator carsIterator = new CarsIterator(cars);
        while (carsIterator.hasNext()) {
            writeAllCarsPosition(stringBuilder, carsIterator.next());
        }
        stringBuilder.append(RacingGameConstant.CARRIAGE_RETURN);

        return stringBuilder.toString();
    }

    private void writeAllCarsPosition(StringBuilder stringBuilder, Car car) {
        stringBuilder.append(car.getName().concat(RacingGameConstant.COLON));
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(RacingGameConstant.CAR_MARKER);
        }
        stringBuilder.append(RacingGameConstant.CARRIAGE_RETURN);
    }
}
