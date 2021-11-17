package racingcarfinal.domain;

import racingcarfinal.utils.RandomUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String name) {
        this.cars = Arrays.stream(name.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.move(RandomUtils.randomInt()));
    }

    public List<Car> findWinners() {
        return findWinners(cars);
    }

    public static List<Car> findWinners(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition().getValue() == max)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
