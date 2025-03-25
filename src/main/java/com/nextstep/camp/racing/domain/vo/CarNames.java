package com.nextstep.camp.racing.domain.vo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarNames {
    private final List<CarName> carNames;

    private CarNames(String carNames) {
        String[] names = carNames.split(",");
        this.carNames = Stream.of(names)
                .map(CarName::of)
                .collect(Collectors.toList());
    }

    private CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(String carNames) {
        return new CarNames(carNames);
    }

    public static CarNames of(List<CarName> carNames) {
        return new CarNames(carNames);
    }

    public Stream<CarName> stream() {
        return carNames.stream();
    }

    public int size() {
        return carNames.size();
    }
}
