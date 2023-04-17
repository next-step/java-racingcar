package study.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames, MoveConditionStrategy moveConditionStrategy) {
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

    private List<Car> createCars(String[] carNames,
                                 MoveConditionStrategy moveConditionStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], moveConditionStrategy));
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

    public List<String> findWinner() {
        int max = cars.stream()
                .mapToInt(e -> e.getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(e -> e.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
