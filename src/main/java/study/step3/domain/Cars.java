package study.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int countOfCar, MoveConditionStrategy moveConditionStrategy) {
        this.cars = createCars(countOfCar, moveConditionStrategy);
    }

    public void moveForward() {
        cars.forEach(Car::moveForward);
    }

    public List<Integer> toPositionOfCars() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Car> createCars(int countOfCar,
                                 MoveConditionStrategy moveConditionStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < countOfCar; i++) {
            cars.add(new Car(moveConditionStrategy));
        }
        return cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
