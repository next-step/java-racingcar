package racing.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(final Random random) {
        cars.forEach(car -> car.move(random));
    }

    public List<String> findWinnerNames() {
        final int maxPosition = maxPosition();
        return cars.stream()
                   .filter(car -> car.matchPosition(maxPosition))
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    private int maxPosition() {
        return cars.stream()
                   .mapToInt(Car::getPosition)
                   .max()
                   .orElseThrow(() -> new RuntimeException("Cars에 Car가 저장되지 않는 경우는 일어날 수 없습니다."));
    }
}
