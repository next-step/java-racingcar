package racing;

import java.util.ArrayList;
import java.util.List;

class Winners {
    static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, maxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }
}
