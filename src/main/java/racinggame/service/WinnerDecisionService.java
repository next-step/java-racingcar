package racinggame.service;

import racinggame.domain.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinnerDecisionService {

    public static List<Car> getWinnerList(List<Car> cars) {
        int maximumPosition = getMaximumPosition(cars);

        return cars.stream()
                        .filter(c -> c.getPosition() == maximumPosition)
                        .collect(toList());
    }

    static int getMaximumPosition(List<Car> cars) {
        return cars.stream()
                        .mapToInt(Car::getPosition)
                        .max()
                        .orElse(Car.INITIAL_POSITION);
    }
}
