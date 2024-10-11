package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceWinner {

    private List<Car> list;

    public RaceWinner(List<Car> cars) {
        int longestMovingDistance = -1;

        longestMovingDistance = findLongestMovingDistance(cars, longestMovingDistance);

        list = decideWinner(cars, longestMovingDistance);
    }

    private List<Car> decideWinner(List<Car> cars, int longestMovingDistance) {
        return cars.stream()
                .filter(it -> it.isSame(longestMovingDistance))
                .collect(Collectors.toList());
    }

    private int findLongestMovingDistance(List<Car> cars, int longestMovingDistance) {
        for (Car car : cars) {
            longestMovingDistance = car.isLongest(longestMovingDistance);
        }
        return longestMovingDistance;
    }

    public List<Car> getWinnerList() {
        return list;
    }

}
