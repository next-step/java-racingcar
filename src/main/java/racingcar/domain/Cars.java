package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.domain.RandomNumber.isNotLessThanThreshold;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race(int movableThreshold) {
        cars.forEach(car -> car.moveForward(movableThreshold));
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
