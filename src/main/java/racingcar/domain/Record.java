package racingcar.domain;

public class Record {

    private final int tryCount;
    private final RacingCars cars;

    public Record(int tryCount, RacingCars cars) {

        this.tryCount = tryCount;
        this.cars = cars;
    }
}
