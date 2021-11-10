package com.kakao.racingcar.domain.car;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CarCollection {

    private final List<Car> cars;

    private static final int OUT_OF_INDEX = -1;

    public CarCollection(List<String> userNames) {
        this.cars = userNames.stream()
                .map(userName -> new Car(userName, new RandomStrategy()))
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

    public List<Car> getWinner() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(OUT_OF_INDEX);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
