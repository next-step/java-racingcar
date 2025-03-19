package racingcar.racing;

public class Racing {
    private final Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public void start() {
        cars.moveAll();
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}