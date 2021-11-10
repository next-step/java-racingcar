package com.step3.model.car;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        List<Car> cars = new LinkedList<>();

        for (int idx = 0; idx < carCount; idx++) {
            cars.add(new Car(new Name("idx"), new Position(0)));
        }

        this.cars = cars;
    }

    public Cars(String[] carsName) {
        List<Car> cars = new LinkedList<>();

        for (String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(0)));
        }

        this.cars = cars;
    }

    public List<Car> getWinnerCars() {
        int maxPosition = cars.stream().mapToInt(c -> c.getPosition().getPosition()).max().getAsInt();
        return cars.stream()
                .filter(c -> c.getPosition().getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}