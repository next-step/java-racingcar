package com.step3.model.car;

import com.step3.model.car.strategy.CarMoveStrategy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFromName(String[] carsName) {
        List<Car> cars = new LinkedList<>();

        for (String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(0), new CarMoveStrategy()));
        }

        return Cars.createFromList(cars);
    }

    public static Cars createFromList(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveCars() {
        for (Car car : this.cars) {
            car.move(car.getMoveStrategy().isMove());
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
}