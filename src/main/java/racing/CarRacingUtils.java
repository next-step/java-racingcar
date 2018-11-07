package racing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CarRacingUtils {

    private CarRacingUtils() {
    }

    public static List<Car> findWinnders(final List<Car> cars) throws IllegalArgumentException {

        if (cars == null) {
            throw new IllegalArgumentException();
        }

        final List<Car> winners = new ArrayList<>();

        final Optional<Car> maxPositionCar = cars.stream().max(Comparator.comparing(Car::getPosition));
        maxPositionCar.ifPresent(car -> winners.addAll(winnerCalculator(cars, car)));

        return winners;
    }

    private static List<Car> winnerCalculator(final List<Car> cars, final Car car) {
        return cars.stream()
                .filter(c -> c.isEqualsPosition(car.getPosition()))
                .collect(Collectors.toList());
    }

}
