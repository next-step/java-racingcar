package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.RandomGenerator.getRandomInteger;

public class RacingCycle {

    private static final int BOUND_NUMBER = 10;

    private final List<Car> cycle = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    public RacingCycle(List<Car> status) {
        for (Car car : status) {
            cycle.add(new Car(car.getName(), car.getLocation()));
        }
    }

    void doCycle() {
        moveCar();
        findWinners();
    }

    private void moveCar() {
        for (Car car : cycle) {
            int number = getRandomInteger(BOUND_NUMBER);
            car.move(number);
        }
    }

    private void findWinners() {
        int maxLocation = findMaxLocation();

        List<Car> winners = cycle.stream()
                .filter(c -> c.equalsLocation(maxLocation))
                .collect(Collectors.toList());

        this.winners.addAll(winners);
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

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }

}
