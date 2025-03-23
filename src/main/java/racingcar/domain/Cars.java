package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars fromNumbers(int count) {
        String[] names = IntStream.range(1, count + 1)
                .mapToObj(i -> "Car" + i)
                .toArray(String[]::new);

        return fromNames(names);
    }

    public static Cars fromNames(String[] names) {
        validCarNames(names);
        List<Car> carList = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    private static void validCarNames(String[] names) {
        if (Arrays.stream(names).distinct().count() < names.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void moveAll(MovingStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getCurrentStatus() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
