package study.carrace.step3.application;

import study.carrace.step3.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_RANDOM_INTEGER = 9;
    private static final String LINE_BREAK = "\n";
    private final List<Car> cars;

    public RaceManager(List<String> carNames) {
        this.cars = cars(carNames);
    }

    public void moveOrStopCars() {
        cars.forEach(car -> car.moveOrStop());
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

    private static List<Car> cars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, randomMoveStrategy()))
                .collect(Collectors.toList());
    }

    private static MoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy(randomIntegerGenerator(), MOVABLE_THRESHOLD);
    }

    private static RandomIntegerGenerator randomIntegerGenerator() {
        return new RandomZeroAndPositiveIntegerGenerator(MAX_RANDOM_INTEGER);
    }
}
