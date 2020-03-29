package CarRacing.domain;

import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(final List<Car> carList) {
        this.racingCars = carList;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void race(final RacingStrategy racingStrategy) {
        for (Car car : racingCars) {
            car.move(racingStrategy);
        }
    }
}
