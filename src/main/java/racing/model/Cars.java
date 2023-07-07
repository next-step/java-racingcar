package racing.model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_BOUND = 10;
    private static final int DEFAULT_CRITERION = 4;
    private static final int DEFAULT_STEPS = 1;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int randomValue = ThreadLocalRandom.current().nextInt(DEFAULT_BOUND);
            if (DEFAULT_CRITERION <= randomValue) {
                car.move(DEFAULT_STEPS);
            }
        }
    }

    public List<String> findWinnerNames() {
        int maxPosition = getMaxPosition();
        return this.cars.stream()
                        .filter(cur -> cur.isWinner(maxPosition))
                        .map(Car::getName)
                        .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        cars.forEach(car -> builder.append(car).append('\n'));
        return builder.toString();
    }

    private int getMaxPosition() {
        return this.cars.stream()
                        .mapToInt(Car::getPosition)
                        .max()
                        .orElseThrow(RuntimeException::new);
    }

}
