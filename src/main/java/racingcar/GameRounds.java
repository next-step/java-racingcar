package racingcar;

public class GameRounds {
    private int round;
    private final Records records;

    public GameRounds(int round) {
        this.round = round;
        this.records = new Records(round);
    }

    public void endRound() {
        round--;
    }

    public void keepRecord(Cars cars) {
        Record record = new Record(cars.getCarPositions());
        this.records.addRecord(record);
    }

    public boolean isGameEnd() {
        return round == 0;
    }

    public Records getRecords() {
        return records;
    }
}
