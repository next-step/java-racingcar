package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void racing() {
        for (Car car : cars) {
            car.moveForward(new RandomMovingStrategy());
        }
    }

    public List<Car> extractWinner() {
        int maxMoveDistance = getMaxMoveDistance(cars);

        return cars.stream()
                .filter(o -> o.getMoveDistance() == maxMoveDistance)
                .collect(Collectors.toList());
    }

    private int getMaxMoveDistance(List<Car> cars) {
        int maxMoveDistance = 0;
        for (Car car : cars) {
            maxMoveDistance = compareMoveDistance(maxMoveDistance, car);
        }
        return maxMoveDistance;
    }

    private int compareMoveDistance(int maxMoveDistance, Car car) {
        return Math.max(car.getMoveDistance(), maxMoveDistance);
    }
}
