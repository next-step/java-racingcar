package com.nextstep.racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<Car> cars) {
        List<Car> unmodifiableCars = Collections.unmodifiableList(new ArrayList<>(cars));
        return new Cars(unmodifiableCars);
    }

    public static Cars createRandomCarsByNumber(int carNumber, CarFactory carFactory) {
        return new Cars(carFactory.createByNumber(carNumber));
    }

    public static Cars createRandomCarsByDriverNames(List<String> driverNames, CarFactory carFactory) {
        return new Cars(carFactory.createByStringList(driverNames));
    }

    public int size() {
        return this.cars.size();
    }

    public List<MoveLength> getMoveLengths() {
        List<MoveLength> moveLengths = cars.stream()
                .map(Car::getMoveLength)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(moveLengths);
    }

    public void moveAll(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }
}
