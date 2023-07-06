package racing.model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_BOUND = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int randomValue = ThreadLocalRandom.current().nextInt(DEFAULT_BOUND);
            car.moveByRandomValue(randomValue);
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
        int maxPosition = -1;
        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

}
