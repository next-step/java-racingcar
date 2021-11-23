package carracing.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        getMaximumDistance(cars);

        this.winners = cars;
    }

    public List<Car> getWinners() {
        int maximumDistance = getMaximumDistance(this.winners);
        return this.winners.stream()
                .filter(car -> car.getPosition() == maximumDistance)
                .collect(Collectors.toList());
    }

    private int getMaximumDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
