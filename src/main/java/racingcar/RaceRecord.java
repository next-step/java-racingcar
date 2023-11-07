package racingcar;

public class RaceRecord {
    private Car car;
    private int distance;

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
