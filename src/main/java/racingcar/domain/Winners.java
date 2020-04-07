package racingcar.domain;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<Car> findWinners(List<Car> cars) {
        return filterWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> filterWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car: cars) {
            car.addWhenWinner(winners, maxPosition);
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
