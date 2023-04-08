package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int carCount;
    private final int roundCount;

    public Game(final InputData inputData) {
        carCount = inputData.getCarCount();
        roundCount = inputData.getRoundCount();
    }

    public List<Records> playGame() {
        Factory factory = new Factory(carCount);
        return simulateRounds(factory);
    }

    private List<Records> simulateRounds(final Factory factory) {
        List<Records> allRecords = new ArrayList<>();

        for (int i = 0; i < roundCount; i++) {
            Records roundRecords = new Records(roundCount);
            race(factory, roundRecords);
            allRecords.add(roundRecords);
        }

        return allRecords;
    }

    private void race(final Factory factory, final Records records) {
        for (Car car : factory.getCars()) {
            car.move();
            addRecord(records, car.getPosition());
        }
    }

    private void addRecord(final Records records, final int position) {
        records.addRecord(new Record(position));
    }

}
