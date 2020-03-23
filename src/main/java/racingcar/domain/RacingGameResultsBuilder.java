package racingcar.domain;

import java.util.Map;

public class RacingGameResultsBuilder {
    private final Map<Integer, Cars> racingGameHistory;

    public RacingGameResultsBuilder(Map<Integer, Cars> racingGameHistory) {
        this.racingGameHistory = racingGameHistory;
    }

    public String getRenderedGameResults() {
        StringBuilder collectResult = new StringBuilder();
        racingGameHistory.entrySet()
                .stream()
                .forEach(e ->{
                    System.out.println(e.getKey() + ": " + e.getValue().toString());
                    collectResult.append(getResults(e.getValue()));
                });

        return collectResult.toString();
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
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(RacingGameConstant.CAR_MARKER);
        }
        stringBuilder.append(RacingGameConstant.CARRIAGE_RETURN);
    }

}
