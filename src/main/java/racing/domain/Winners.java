package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public final class Winners {
    private Winners() {}

    public static List<String> getWinners(final List<Car> lastRoundResult) {
        final int maxLocation = getMaxLocation(lastRoundResult);
        return lastRoundResult.stream()
                .filter((car) -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxLocation(final List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .orElseThrow(NullPointerException::new)
                .getLocation();
    }
}
