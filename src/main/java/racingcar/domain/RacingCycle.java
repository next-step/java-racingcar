package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.domain.Cycles.FIRST_INDEX;
import static racingcar.util.RandomGenerator.getRandomInteger;

public class RacingCycle {

    private static final int BOUND_NUMBER = 10;

    private final List<Car> cycle = new ArrayList<>();

    public RacingCycle(RacingCycle lastRacingCycle) {
        readyLastCars(lastRacingCycle.getCycle());
        doCycle();
    }


    public RacingCycle(List<String> carNames) {
        readyCars(carNames);
        doCycle();
    }

    private void doCycle() {
        for (Car car : cycle) {
            int number = getRandomInteger(BOUND_NUMBER);
            car.move(number);
        }
    }

    public int findMaxLocation() {
        return cycle.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(FIRST_INDEX);
    }

    public List<Car> getCycle() {
        return Collections.unmodifiableList(cycle);
    }

    private void readyCars(List<String> carNames) {
        for (String s : carNames) {
            cycle.add(new Car(s));
        }
    }

    private void readyLastCars(List<Car> status) {
        for (Car car : status) {
            Car newCar = new Car(car.getName(), car.getLocation());
            cycle.add(newCar);
        }
    }
}
