package com.nextstep.racingcar.domain.car;

import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }
}
