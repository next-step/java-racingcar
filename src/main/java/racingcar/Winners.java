package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static void addCarToListIfThisPositionIsMatch(Car car, int position, List<Car> winners) {
        if (car.isMatch(position)) {
            winners.add(car);
        }
    }
    public static List<Car> findWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addCarToListIfThisPositionIsMatch(car, maxPosition, winners);
        }

        return winners;
    }
}
