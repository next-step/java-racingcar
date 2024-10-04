package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;
        for (Car car : RacingGame.cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        for (Car car : RacingGame.cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
