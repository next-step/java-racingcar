package study.step5.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final String DELIMITER = ",|:";

    private int attemptCount;
    private Cars cars;

    public Track(final String carNames, final int attemptCount) {
        this.attemptCount = attemptCount;
        createCars(carNames);
    }

    private void createCars(final String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(DELIMITER)) {
            cars.add(new Car(carName));
        }
        this.cars = new Cars(cars);
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
