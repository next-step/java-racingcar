package race;

import java.util.Comparator;
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

    public List<String> findWinners() {
        int highDistance = findHighDistance();
        return cars.stream()
                .filter(car -> car.getTotalDistance() >= highDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private int findHighDistance() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getTotalDistance)).get()
                .getTotalDistance();
    }

    private boolean movable() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_BOUND;
    }

}
