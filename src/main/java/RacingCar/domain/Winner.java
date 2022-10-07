package RacingCar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    public List<Car> findWinners(List<Car> cars) {
        var car = cars.stream().max(Comparator.comparing(Car::getPosition)).orElse(null);

        if (car == null) {
            return null;
        }

        int max = car.getPosition();

        return cars.stream().filter(x -> x.isSamePosition(max)).collect(Collectors.toList());
    }
}
