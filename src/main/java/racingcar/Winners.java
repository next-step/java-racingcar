package racingcar;

import java.util.List;

public class Winners {
    private Winners() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Car> findWinners(Cars cars) {
         return findWinners(cars, maxPosition(cars));
    }

    public static List<Car> findWinners(Cars cars, int maxPosition) {
        return cars.getWinners(maxPosition);
    }

    private static int maxPosition(Cars cars) {
        int maxPosition  = 0;
        for (Car car: cars.getCars()) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }
}
