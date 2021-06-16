package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Award {

    public List<Car> findWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxPosition = findMaxPosition(cars);
        for (Car car : cars) {
            if (car.isInPosition(maxPosition)) {
                winner.add(car);
            }
        }
        return winner;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = car.whichOneIsBiggerThan(maxPosition);
        }
        return maxPosition;
    }

    public String winnerIS(List<Car> winner) {
        StringBuilder winnerIS = new StringBuilder();
        for(Car car : winner) {
            winnerIS.append(car.getName()).append(",");
        }
        winnerIS.deleteCharAt(winnerIS.lastIndexOf(","));
        return winnerIS.toString();
    }
}
