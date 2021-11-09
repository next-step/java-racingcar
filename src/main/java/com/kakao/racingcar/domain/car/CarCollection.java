package com.kakao.racingcar.domain.car;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CarCollection {
    private final List<Car> cars;

    public CarCollection(List<String> userNames) {
        this.cars = userNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void tryMoveCars(List<Integer> conditionNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).tryMove(conditionNumbers.get(i));
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
