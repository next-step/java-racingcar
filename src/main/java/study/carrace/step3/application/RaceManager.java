package study.carrace.step3.application;

import study.carrace.step3.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private static final String LINE_BREAK = "\n";
    private final List<Car> cars;

    public RaceManager(List<String> carNames, MoveStrategy moveStrategy) {
        this.cars = cars(carNames, moveStrategy);
    }

    public void moveOrStopCars() {
        cars.forEach(Car::moveOrStop);
    }

    public String carsPosition() {
        StringBuilder carsPosition = new StringBuilder();
        cars.forEach(car -> carsPosition.append(car.currentPosition()).append(LINE_BREAK));

        return carsPosition.toString();
    }

    public List<String> winners() {
        return findCarsBy(maxNumberOfMove());
    }

    private List<String> findCarsBy(long numberOfMove) {
        return cars.stream()
                .filter(car -> car.numberOfMove() == numberOfMove)
                .map(car -> car.name())
                .collect(Collectors.toList());
    }

    private long maxNumberOfMove() {
        return cars.stream()
                .map(Car::numberOfMove)
                .mapToLong(l -> l)
                .max()
                .getAsLong();
    }

    private static List<Car> cars(List<String> carNames, MoveStrategy moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }
}
