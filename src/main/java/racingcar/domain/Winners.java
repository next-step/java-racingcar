package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public List<Car> findWinners(final Cars cars) {
        int maxPosition = cars.getMaxPosition();

        return cars.getCars().stream()
            .filter(car -> car.isAtMaxPosition(maxPosition))
            .collect(Collectors.toList());
    }

}
