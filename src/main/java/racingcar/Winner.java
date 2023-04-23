package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static List<String> getWinnerCarNames(Cars cars) {
        List<String> carNames = new ArrayList<>();

        int maxDistance = maxDistance(cars);
        for (Car car : cars.list()) {
            addCarNameNaxDistanceGreaterThanOrEqual(maxDistance, car, carNames);
        }
        return carNames;
    }

    private static void addCarNameNaxDistanceGreaterThanOrEqual(int maxDistance, Car car, List<String> carNames) {
        if (car.distanceDriven() >= maxDistance) {
            carNames.add(car.name());
        }
    }

    private static int maxDistance(Cars cars) {
        int maxDistance = 0;
        for (Car car : cars.list()) {
            maxDistance = Math.max(maxDistance, car.distanceDriven());
        }
        return maxDistance;
    }
}
