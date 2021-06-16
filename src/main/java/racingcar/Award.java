package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Award {

    public List<Car> findWinner(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        int maxPosition = findMaxPosition(cars);
        for (Car car : cars) {
            if (car.isInPosition(maxPosition)) {
                result.add(car);
            }
        }
        return result;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = car.whichOneIsBiggerThan(maxPosition);
        }
        return maxPosition;
    }

    public String winnerIS(List<Car> result) {
        StringBuilder winner = new StringBuilder();
        for(Car car : result) {
            winner.append(car.getName()).append(",");
        }
        winner.deleteCharAt(winner.lastIndexOf(","));
        return winner.toString();
    }
}
