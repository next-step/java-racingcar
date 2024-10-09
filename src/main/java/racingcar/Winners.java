package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxPosition == car.getCurrentPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getCurrentPosition(), maxPosition);
        }
        return maxPosition;
    }
}
