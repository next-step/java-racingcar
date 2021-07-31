package racingcar;

public class Lap {
    private final Records records;

    public Lap(Cars cars) {
        this.records = new Records(cars);
    }

    public Records getRecords() {
        return records;
    }
}
