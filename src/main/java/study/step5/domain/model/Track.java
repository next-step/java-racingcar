package study.step5.domain.model;

import java.util.List;

public class Track {
    private int attemptCount;
    private Cars cars;

    public Track(final String carNames, final int attemptCount) {
        this.attemptCount = attemptCount;
        createCars(carNames);
    }

    private void createCars(final String carNames) {
        this.cars = Cars.from(carNames);
    }

    public void startRacing() {
        cars.startRacing();
        attemptCount--;
    }

    public boolean isRaceEnd() {
        return attemptCount == 0;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinnerCars() {
        return cars.getWinners();
    }
}
