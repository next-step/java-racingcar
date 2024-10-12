package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceWinner {

    private final List<Car> winners;

    public RaceWinner(List<Car> cars) {
        int longestMovingDistance = findLongestMovingDistance(cars);
        winners = decideWinner(cars, longestMovingDistance);
    }

    private List<Car> decideWinner(List<Car> cars, int longestMovingDistance) {
        return cars.stream()
                .filter(it -> it.isSame(longestMovingDistance))
                .collect(Collectors.toList());
    }

    private int findLongestMovingDistance(List<Car> cars) {
        int longestMovingDistance = -1;

        for (Car car : cars) {
            longestMovingDistance = car.longest(longestMovingDistance);
        }
        return longestMovingDistance;
    }

    public List<Car> getWinners() {
        return winners;
    }

}
