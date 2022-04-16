package core;

import utils.PowerSupply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(List<CarName> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::create)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveCarsRandomly(PowerSupply powerSupply) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(powerSupply.supply()));
        }
        return Cars.fromCars(movedCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
