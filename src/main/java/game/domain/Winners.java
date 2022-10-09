package game.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private Winners() {
    }

    public static Cars findWinners(final Cars cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static Cars findWinners(final Cars cars, final int maxPosition) {
        List<Car> winners = new ArrayList<>();
        cars.getCarList().stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .forEach(winners::add);
        return new Cars(winners);
    }

    private static int getMaxPosition(final Cars cars) {
        int maxPosition = 0;
        for (Car car : cars.getCarList()) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }
}
