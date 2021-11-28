package study.racinggame.domain.car;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(Names names) {
        cars = names.getNames()
                .stream().map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        this.cars.forEach(car -> {
                    MovingStrategy movingStrategy = new Engine();
                    car.move(movingStrategy);
                }
        );
    }

    public List<Car> winners() {
        return this.cars.stream()
                .filter(car -> car.isWinner(maxPosition()))
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new NoSuchElementException("최대값을 구할 수 없습니다."));
    }

    public List<Car> getCars() {
        return cars;
    }
}
