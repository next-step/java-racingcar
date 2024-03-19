package game.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public String getWinners(List<Car> cars){
        int maxDistance = calcMaxDistance(cars);
        return selectWinners(cars, maxDistance);
    }

    private int calcMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private String selectWinners(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(o -> o.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
