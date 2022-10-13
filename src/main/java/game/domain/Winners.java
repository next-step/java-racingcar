package game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private Winners() {
    }

    public static Cars findWinners(final Cars cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static Cars findWinners(final Cars cars, final int maxPosition) {
        List<Car> winners = new ArrayList<>();
        cars.getCarList().stream()
                .filter(car -> car.hasSamePosition(maxPosition))
                .forEach(winners::add);
        return new Cars(winners);
    }

    private static int getMaxPosition(final Cars cars) {
        List<Position> positionList = cars.getCarList().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        return Collections.max(positionList).getPosition();
    }
}
