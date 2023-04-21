package study.carrace.step3.application;

import study.carrace.step3.domain.*;
import study.carrace.step3.domain.exception.IllegalIterationCountException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceManager {
    private static final String LINE_BREAK = "\n";
    private final List<Car> cars;
    private final int iterationCount;

    public RaceManager(List<String> carNames, MoveStrategy moveStrategy, int iterationCount) {
        validateIterationCount(iterationCount);

        this.cars = cars(carNames, moveStrategy);
        this.iterationCount = iterationCount;
    }

    public void startRace() {
        IntStream.range(0, iterationCount)
                .forEach(iteration -> moveOrStopCars());
    }

    public String carsPositionHistory() {
        StringBuilder carsPositionHistory = new StringBuilder();
        IntStream.rangeClosed(1, iterationCount)
                .forEach(iteration -> carsPositionHistory.append(carsPositionAt(iteration)).append(LINE_BREAK));

        return carsPositionHistory.toString();
    }

    public List<CarName> winners() {
        return findCarNamesBy(maxNumberOfMove());
    }

    private String carsPositionAt(int iteration) {
        StringBuilder carsPosition = new StringBuilder();
        cars.forEach(car -> carsPosition.append(car.positionAt(iteration)).append(LINE_BREAK));

        return carsPosition.toString();
    }

    private void moveOrStopCars() {
        cars.forEach(Car::moveOrStop);
    }

    private List<CarName> findCarNamesBy(long numberOfMove) {
        return cars.stream()
                .filter(car -> car.numberOfMove() == numberOfMove)
                .map(Car::carName)
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

    private void validateIterationCount(int iterationCount) {
        if (iterationCount <= 0) {
            throw new IllegalIterationCountException(iterationCount);
        }
    }
}
