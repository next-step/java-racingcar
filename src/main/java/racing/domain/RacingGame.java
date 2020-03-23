package racing.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private List<Car> cars;
    private Random random = new Random();

    public RacingGame(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("차 대수는 0 이상이야 합니다.");
        }

        this.cars = cars.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public RacingGame(String[] carNames) {
        this(Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move() {
        cars.forEach(car -> car.moveForward(random.nextInt(10)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        Car winner = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(IllegalStateException::new);

        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .collect(Collectors.toList());
    }

}
