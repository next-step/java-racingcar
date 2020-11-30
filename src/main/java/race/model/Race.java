package race.model;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public Cars run(int runCount) {
        for (int i = 0; i < runCount; i++) {
            runForEachCar();
        }
        return cars;
    }

    private void runForEachCar() {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }
}
