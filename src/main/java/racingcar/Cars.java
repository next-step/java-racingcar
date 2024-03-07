package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(DrivingStrategy drivingStrategy, int amount) {
        for (int i = 0; i < amount; i++) {
            Car car = new Car(drivingStrategy);
            cars.add(car);
        }
    }

    public void drive() {
        for (Car car : cars) {
            car.drive();
        }
    }

    public List<Integer> drivingDistances() {
        return cars.stream()
            .map(Car::drivingDistance)
            .collect(Collectors.toList());
    }

    public String getResult() {
        return cars.stream()
            .map(Car::getResult)
            .collect(Collectors.joining("\n"));
    }
}
