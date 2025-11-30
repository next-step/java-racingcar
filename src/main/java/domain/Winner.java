package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static Position getMaxPosition(List<Car> cars) {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }

        return maxPosition;
    }

    public static List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        Position maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car.name());
            }
        }

        return winners;
    }
}
