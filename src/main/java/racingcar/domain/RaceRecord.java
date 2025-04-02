package racingcar.domain;

public class RaceRecord {

    private final Cars cars;

    public RaceRecord(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return this.cars;
    }
}
