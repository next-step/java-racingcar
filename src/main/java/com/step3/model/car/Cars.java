package com.step3.model.car;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carsName) {
        List<Car> cars = new LinkedList<>();

        for (String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(0)));
        }

        this.cars = cars;
    }

    public List<Car> getWinnerCars() {
        int maxPosition = cars.stream().mapToInt(c -> c.getPosition().getValue()).max().getAsInt();
        return cars.stream()
                .filter(c -> c.getPosition().getValue() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}