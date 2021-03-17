package racingcar.domain;

public class Record {
    private final Cars record;

    public Record(Cars cars) {
        this.record = cars;
    }

    public Cars getRecord() {
        return this.record;
    }

}
