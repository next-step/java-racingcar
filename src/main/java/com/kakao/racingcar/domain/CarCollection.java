package com.kakao.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.kakao.racingcar.domain.CarConfig.BEGIN_INDEX;

public class CarCollection {
    private final List<Car> cars;

    public CarCollection(int totalCars) {
        this.cars = IntStream.range(BEGIN_INDEX, totalCars)
                .boxed()
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

}
