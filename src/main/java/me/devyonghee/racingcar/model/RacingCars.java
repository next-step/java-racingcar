package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

final class RacingCars {

    private final Collection<RacingCar> cars;

    private RacingCars(Collection<RacingCar> cars) {
        Assert.notNull(cars, "'cars' must not be null");
        this.cars = new ArrayList<>(cars);
    }

    static RacingCars from(Collection<RacingCar> cars) {
        return new RacingCars(cars);
    }

    <T> List<T> map(Function<RacingCar, T> function) {
        return cars.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    int size() {
        return cars.size();
    }
}
