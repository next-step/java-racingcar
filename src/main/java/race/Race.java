package race;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public Positions startLap() {
        cars.moveAll();
        return cars.getPositions();
    }
}
