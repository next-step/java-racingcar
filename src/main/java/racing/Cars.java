package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    public static final int RANDOM_VALUE_UPPER_BOUND = Car.UPPER_BOUND + 1;
    private static final Random RANDOM = new Random();
    private final List<Car> cars;

    private Cars(int count) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }

    public static Cars init(int count) {
        return new Cars(count);
    }

    public void move() {
        cars.forEach(car -> {
            int randomValue = RANDOM.nextInt(RANDOM_VALUE_UPPER_BOUND);
            car.goForward(randomValue);
        });
    }

    public List<Integer> getCarsPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
