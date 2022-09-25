package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final Random random = new Random();
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Distance> move() {
        List<Distance> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.move(new MovingFlag(movingValue())));
        }
        return results;
    }

    private int movingValue() {
        return random.nextInt(10);
    }
}
