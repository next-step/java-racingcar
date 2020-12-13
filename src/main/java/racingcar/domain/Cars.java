package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int DEFAULT_VALUE = 0;
    private final List<Car> carList = new ArrayList<>();

    public Cars(String[] carNameArr) {
        Arrays.stream(carNameArr).map(Car::new).forEach(carList::add);
    }

    public List<Car> getCars() {
        return carList;
    }

    public void move() {
        carList.forEach(car -> car.move(new RandomGenerator()));
    }

    public int getMaxLocation() {
        return this.carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(DEFAULT_VALUE);
    }

    public String getWinnerCarNames() {
        return this.carList.stream()
                .filter(car -> car.getLocation() == getMaxLocation())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
