package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<Car> findWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);
        for (Car car : cars) {
            addWhenWinner(winners, maxPosition, car);
        }
        return winners;
    }

    private static void addWhenWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
