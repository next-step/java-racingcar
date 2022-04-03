package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(List<String> carNames) {
        List<Car> receivedCars = new ArrayList<>();
        for (String carName : carNames) {
            receivedCars.add(Car.create(carName));
        }

        return new Cars(receivedCars);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveCarsRandomly(Random random) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(random.nextInt(Car.MAX_MOVE_VALUE)));
        }
        return Cars.fromCars(movedCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
