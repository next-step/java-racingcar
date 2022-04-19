package racing.domain;

import java.util.List;

public class Competition {
    private final Cars cars;
    private final int round;
    private final RoundRecords records;

    public Competition(String[] carNames, int round) {
        cars = new Cars(carNames);
        this.round = round;
        this.records = new RoundRecords();
    }

    public List<Cars> progressCompetitionAndgetEntireRecords(Movable movable) {
        for (int i = 0; i < round; i++) {
            progressEachRound(movable);
            saveEachRoundRecord();
        }

        return records.getEntrieRecords();
    }

    private void progressEachRound(Movable movable) {
        cars.move(movable);
    }

    private void saveEachRoundRecord() {
        records.addRoundRecord(cars);
    }

    public List<Car> getCarsWithMaxDistance() {
        return cars.getCarsWithMaxDistance();
    }
}
