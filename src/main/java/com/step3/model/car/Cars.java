package com.step3.model.car;

import com.step3.model.car.strategy.CarMoveStrategy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carsName) {
        List<Car> cars = new LinkedList<>();

        for (String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(0), new CarMoveStrategy()));
        }

        this.cars = cars;
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveCars() {
        for (Car car : this.cars) {
            car.move(car.getMoveStrategy().isMove());
        }

        return new Cars(cars);
    }

    public Cars getWinnerCars() {
        int maxPosition = cars.stream().mapToInt(c -> c.getPosition().getValue()).max().getAsInt();
        List<Car> winnerCars = cars.stream()
                .filter(c -> c.getPosition().getValue() == maxPosition)
                .collect(Collectors.toList());

        return new Cars(winnerCars);
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(cars);
    }
}