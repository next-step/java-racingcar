package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public Referee() {
    }

    private int getMaxMovingDistance(List<Car> cars) {
        int maxMovingDistance = 0;

        for (Car car : cars) {
            int movingDistance = car.getPosition();
            if (maxMovingDistance < movingDistance) {
                maxMovingDistance = movingDistance;
            }
        }
        return maxMovingDistance;
    }

    public List<String> getWinners(List<Car> cars) {
        int maxMovingDistance = getMaxMovingDistance(cars);

        return cars.stream()
            .filter(car -> car.getPosition() == maxMovingDistance).map(Car::getName)
            .collect(Collectors.toList());
    }

}
