package racing.manager;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import racing.model.Car;

public class RacingManager {

    private static final int DEFAULT_BOUND = 10;

    private final List<Car> cars;

    public RacingManager(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarClones() {
        return this.cars.stream()
                        .map(Car::clone)
                        .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> turn() {
        for (Car car : this.cars) {
            int value = ThreadLocalRandom.current().nextInt(DEFAULT_BOUND);
            car.moveOneStepMoreThanCriterion(value);
        }

        return this.getCarClones();
    }

    public List<Car> checkWinners() {
        int maxPosition = getMaxPosition();
        return this.cars.stream()
                        .filter(cur -> cur.getPosition() == maxPosition)
                        .map(Car::clone)
                        .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

}
