package racingcar.race;

import java.util.List;

public class RacingCars {
    private List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void addCar(Car car) {
        this.racingCars.add(car);
    }
}
