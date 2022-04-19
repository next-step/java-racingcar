package racing.domain;

public class Competition {
    private final Cars cars;
    private final int round;

    public Competition(String[] carNames, int round) {
        cars = new Cars(carNames);
        this.round = round;
    }

    public RoundRecords progressCompetitionAndGetEntireRecords(Movable movable) {
        RoundRecords records = new RoundRecords();
        for (int i = 0; i < round; i++) {
            progressEachRound(movable);
            saveEachRoundRecord(records);
        }

        return records;
    }

    private void progressEachRound(Movable movable) {
        cars.move(movable);
    }

    private void saveEachRoundRecord(RoundRecords records) {
        records.addRoundRecord(cars);
    }
}
