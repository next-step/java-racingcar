package racingcar.domain;

public class RaceRecord {

    private static final int SEQUENCE_INIT = 0;

    private final int sequence;
    private final Cars cars;

    public RaceRecord(Cars cars) {
        this.sequence = SEQUENCE_INIT;
        this.cars = cars;
    }

    public RaceRecord(int sequence, Cars cars) {
        this.sequence = sequence;
        this.cars = cars;
    }

    public int getSequence() {
        return this.sequence;
    }

    public Cars getCars() {
        return this.cars;
    }
}
