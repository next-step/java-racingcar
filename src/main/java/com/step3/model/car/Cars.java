package com.step3.model.car;

import com.step3.model.car.strategy.MoveStrategy;
import com.step3.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFromName(String[] carsName, MoveStrategy moveStrategy) {
        List<Car> cars = new LinkedList<>();

        for (String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(0), moveStrategy));
        }

        return Cars.createFromList(cars);
    }

    public static Cars createFromList(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveCars() {
        for (Car car : this.cars) {
            car.move(RandomUtil.getRandomValue());
        }

        return Cars.createFromList(cars);
    }

    public Cars getWinnerCars() {
        Position maxPosition = cars.stream()
                .map(c -> c.getPosition())
                .max(Position::compareTo)
                .get();

        List<Car> winnerCars = cars.stream()
                .filter(c -> c.getPosition().equals(maxPosition))
                .collect(Collectors.toList());

        return Cars.createFromList(winnerCars);
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