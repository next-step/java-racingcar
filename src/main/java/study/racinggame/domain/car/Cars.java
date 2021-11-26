package study.racinggame.domain.car;

import study.racinggame.domain.RandomNumber;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] splitCarNames) {
        this.cars = Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        this.cars.forEach(car -> {
                    RandomNumber randomNumber = new RandomNumber();
                    car.move(randomNumber.equalsOrBiggerThanCondition());
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
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new NoSuchElementException("최대값을 구할 수 없습니다."));
    }

    public List<Car> getCars() {
        return cars;
    }
}
