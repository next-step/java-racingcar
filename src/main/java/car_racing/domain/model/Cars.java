package car_racing.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Cars {
    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private final List<Car> cars;

    public Cars(int numOfCars) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void moveAll() {
        cars.forEach(car -> {
            if (isMovable()) car.move(DEFAULT_MOVE_DISTANCE);
        });
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    private boolean isMovable() {
        return random.nextInt() > MOVE_THRESHOLD;
    }
}
