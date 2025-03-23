package domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDeterminer {

    public static List<Car> findWinners(Cars cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int findMaxPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}