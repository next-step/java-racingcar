package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<Car> getWinners(List<Car> cars) {
        int max = gameResult(cars);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            checkWinner(car, max, winners);
        }
        return winners;
    }

    private static void checkWinner(Car car, int max, List<Car> winners) {
        if (car.isMax(max)){
            winners.add(car);
        }
    }

    private static int gameResult(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.checkMaxLocation(max);
        }
        return max;
    }

}
