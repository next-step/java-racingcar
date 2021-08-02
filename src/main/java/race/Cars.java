package race;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private int maxTryCount;
    private static final int MINIMUM_BOUND = 4;


    private Cars(Condition condition) {
        this.cars = condition.getNames().stream()
                .map(Car::of)
                .collect(Collectors.toList());
        this.maxTryCount = condition.getTryCount();
    }

    public static Cars of(Condition condition) {
        return new Cars(condition);
    }

    public void moveAll() {
        cars.forEach(car -> {
            for (int tryCount = 0; tryCount < maxTryCount; tryCount++) {
                car.move(movable());
            }
        });
    }

    public String getWinner(int highDistance) {
        return cars.stream()
                .filter(car -> car.getDistance(maxTryCount) >= highDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private boolean movable() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_BOUND;
    }

}
