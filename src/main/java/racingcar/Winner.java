package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return getWinnersByMaxDistance(maxDistance);
    }

    private static int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : RacingGame.cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private static List<Car> getWinnersByMaxDistance(int maxDistance) {
        List<Car> winners = new ArrayList<>();
        for (Car car : RacingGame.cars) {
            addWinnerIfMaxDistance(winners, car, maxDistance);
        }
        return winners;
    }

    private static void addWinnerIfMaxDistance(List<Car> winners, Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winners.add(car);
        }
    }
}
