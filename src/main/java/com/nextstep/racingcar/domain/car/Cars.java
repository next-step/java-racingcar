package com.nextstep.racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<Car> cars) {
        List<Car> unmodifiableCars = Collections.unmodifiableList(new ArrayList<>(cars));
        return new Cars(unmodifiableCars);
    }

    public int size() {
        return this.cars.size();
    }
}
