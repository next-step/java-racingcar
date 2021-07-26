package racingcargame.domain.vehicle;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void doDrive() {
        cars.forEach(Car::drive);
    }

    public WinnerCars getWinners() {
        return new WinnerCars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
