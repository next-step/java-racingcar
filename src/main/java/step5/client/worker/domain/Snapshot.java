package step5.client.worker.domain;


import java.util.List;

public class Snapshot {
    private final List<Car> cars;

    private Snapshot(final List<Car> cars) {
        this.cars = cars;
    }

    public static Snapshot of(final List<Car> carRacingResults) {
        return new Snapshot(carRacingResults);
    }

    public List<Car> getCars() {
        return cars;
    }
}
