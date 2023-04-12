package step3;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final static Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private final List<Car> values;

    public Cars(int numberOfCars) {
        values = Collections.nCopies(numberOfCars, new Car());
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
}
