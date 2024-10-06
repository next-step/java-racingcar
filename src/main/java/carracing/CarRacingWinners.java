package carracing;

import carracing.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingWinners {

    public static List<Car> findWinners(List<Car> cars) {
        int maxPosition = -1;
        maxPosition = getMaxPosition(cars, maxPosition);

        return findWinners(cars, maxPosition);
    }

    private static int getMaxPosition(List<Car> cars, int maxPosition) {
        for(Car car : cars) {
            maxPosition = car.getMax(maxPosition);
        }
        return maxPosition;
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

}
