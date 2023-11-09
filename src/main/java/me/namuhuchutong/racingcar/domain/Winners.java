package me.namuhuchutong.racingcar.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.NoSuchElementException;

public class Winners {

    private final List<String> names;

    public static Winners from(Cars cars) {
        Car winnerCar = findWinnerPosition(cars);
        List<String> collect = cars.getValues()
                                   .stream()
                                   .filter(car -> car.compareTo(winnerCar) == 0)
                                   .map(Car::getName)
                                   .collect(toUnmodifiableList());
        return new Winners(collect);
    }

    private static Car findWinnerPosition(Cars cars) {
        return cars.getValues()
                   .stream()
                   .max(Car::compareTo)
                   .orElseThrow(NoSuchElementException::new);
    }

    public Winners(List<String> names) {
        validateNames(names);
        this.names = names;
    }

    private void validateNames(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("우승자가 존재하지 않습니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
