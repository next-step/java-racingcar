package racingCar.domains;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static List<Car> findWinner(List<Car> cars) {
        int max = maxPosition(cars);
        return winner(cars, max);
    }

    private static int maxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private static List<Car> winner(List<Car> cars, int max) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(max)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
