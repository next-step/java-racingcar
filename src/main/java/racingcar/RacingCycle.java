package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.RandomGenerator.getRandomInteger;

public class RacingCycle {

    private static final int BOUND_NUMBER = 10;

    private final List<Car> cycle = new ArrayList<>();

    public RacingCycle(List<Car> status) {
        for (Car car : status) {
            cycle.add(new Car(car.getLocation()));
        }
    }

    public RacingCycle(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            cycle.add(new Car());
        }
    }

    void doCycle() {
        for (Car car : cycle) {
            int number = getRandomInteger(BOUND_NUMBER);
            car.move(number);
        }
    }

    public List<Car> get() {
        return cycle;
    }
}
