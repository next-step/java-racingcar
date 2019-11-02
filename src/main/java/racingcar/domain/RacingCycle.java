package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.RandomGenerator.getRandomInteger;

public class RacingCycle {

    private static final int BOUND_NUMBER = 10;

    private final List<Car> cycle = new ArrayList<>();
    private int winnerLocation;

    public RacingCycle(List<Car> status) {
        for (Car car : status) {
            Car newCar = new Car(car.getName(), car.getLocation());

            int number = getRandomInteger(BOUND_NUMBER);
            newCar.move(number);
            cycle.add(newCar);
        }
        this.winnerLocation = findMaxLocation();
    }

    public List<String> findWinners() {
        return cycle.stream()
                .filter(c -> c.equalsLocation(winnerLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxLocation() {
        return cycle.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<Car> getCycle() {
        return Collections.unmodifiableList(cycle);
    }

}
