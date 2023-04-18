package race;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public Cars startLap() {
        cars.moveAll();
        return cars;
    }
}
