package carracing;

import carracing.move_strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Cars makeCars(List<String> carNames, MoveStrategy moveStrategy) {
        return new Cars(carNames.stream().map(carName -> new Car(carName, moveStrategy)).collect(Collectors.toList()));
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getFastestCars() {
        int maxPosition = -1;
        List<Car> fastestCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                fastestCars.clear();
                fastestCars.add(car);
            } else if (car.getPosition() == maxPosition) {
                fastestCars.add(car);
            }
        }
        return fastestCars;
    }
}
