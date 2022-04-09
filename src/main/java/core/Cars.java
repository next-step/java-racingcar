package core;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(List<CarName> carNames) {
        List<Car> receivedCars = new ArrayList<>();
        for (CarName carName : carNames) {
            receivedCars.add(Car.create(carName));
        }

        return new Cars(receivedCars);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveCarsRandomly(NumberGenerator numberGenerator) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(numberGenerator.next()));
        }
        return Cars.fromCars(movedCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
