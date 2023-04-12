package step3.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final static Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    final List<Car> values;

    public Cars(int numberOfCars) {
        values = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            values.add(new Car());
        }
    }

    public void move() {
        values.stream()
                .forEach(car ->
                        car.move(randomNumber())
                );
    }

    private int randomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public List<Car> cars() {
        return values;
    }
}
