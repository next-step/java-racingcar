package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCycle {

    private static final int BOUND_NUMBER = 10;
    private List<Car> cycle = new ArrayList<>();
    private Random random;

    public RacingCycle(List<Car> status) {

        for (Car car : status) {
            cycle.add(new Car(car.getLocation()));
        }

        this.random = new Random();
    }

    public RacingCycle(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            cycle.add(new Car());
        }
        this.random = new Random();
    }

    public void doCycle() {
        for (Car car : cycle) {
            int number = random.nextInt(BOUND_NUMBER);
            car.move(number);
        }
    }

    public List<Car> get() {
        return cycle;
    }
}
