package racingcar.domain;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = makeCars(carNames);
    }

    private static List<Car> makeCars(String[] carNames) {
        return Arrays.stream(carNames)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxDistance() {
        return cars.stream()
                   .mapToInt(Car::getDistance)
                   .max()
                   .orElse(0);
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                   .filter(car -> car.isWinner(maxDistance))
                   .collect(Collectors.toList());
    }
}
