package racingcar.race;

public class RaceRecord {
    private final Car car;
    private final int distance;

    public RaceRecord(Car car) {
        this.car = car;
        this.distance = car.distance();
    }

    public Car car() {
        return car;
    }

    public int distance() {
        return distance;
    }
}
