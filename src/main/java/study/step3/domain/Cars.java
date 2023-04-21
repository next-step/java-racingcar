package study.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(List<String> carNames, MoveConditionStrategy moveConditionStrategy) {
        this.cars = createCars(carNames, moveConditionStrategy);
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

    private List<Car> createCars(List<String> carNames,
                                 MoveConditionStrategy moveConditionStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, moveConditionStrategy));
        }
        return cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> toCarNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> findWinners() {
        int max = cars.stream()
                .mapToInt(e -> e.getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(e -> e.isEqualsPosition(max))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
