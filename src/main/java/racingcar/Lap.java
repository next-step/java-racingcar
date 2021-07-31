package racingcar;

public class Lap {
    private final Records records;

    public Lap(Cars cars) {
        this.records = new Records(cars);
    }

    public Records getRecords() {
        return records;
    }

    public Records getBestRecords() {
        Records bestRecords = new Records();
        for (Record record : records) {
            bestRecords.recordBest(record);
        }
        return bestRecords;
    }
}
