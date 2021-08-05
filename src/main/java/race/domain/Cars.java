package race.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final int maxTryCount;
    private static final int MINIMUM_BOUND = 4;


    public Cars(Condition condition) {
        this.cars = condition.getNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.maxTryCount = condition.getTryCount();
    }

    public void playUntilEnd() {
        for (int tryCount = 0; tryCount < maxTryCount; tryCount++) {
            playOneRound();
        }
    }

    public List<Name> findWinners() {
        int highDistance = findHighestDistance();
        return cars.stream()
                .filter(car -> car.getDistance(maxTryCount) >= highDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> findCarsInfo() {
        return this.cars;
    }

    private int findHighestDistance() {
        return cars.stream()
                .map(car -> car.getDistance(maxTryCount))
                .max(Integer::compare).get().intValue();
    }

    private void playOneRound() {
        cars.forEach(car -> car.move(movable()));
    }

    private boolean movable() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_BOUND;
    }

}
