package com.step3.model.car;

import com.step3.model.car.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFromName(String[] carsName) {
        List<Car> cars = new LinkedList<>();

        for (String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(0)));
        }

        return Cars.createFromList(cars);
    }

    public static Cars createFromList(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveCars(MoveStrategy moveStrategy) {
        for (Car car : this.cars) {
            car.move(moveStrategy);
        }

        return Cars.createFromList(cars);
    }

    public Cars getWinnerCars() {
        List<Car> winnerCars = cars.stream()
                .filter(c -> c.getPosition().equals(getWinnerCarPosition()))
                .collect(Collectors.toList());

        return Cars.createFromList(winnerCars);
    }

    private Position getWinnerCarPosition() {
        return cars.stream()
                .map(c -> c.getPosition())
                .max(Position::compareTo)
                .get();
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars1.cars.containsAll(cars) && cars.containsAll(cars1.cars);
    }
}