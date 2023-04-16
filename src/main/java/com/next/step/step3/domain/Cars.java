package com.next.step.step3.domain;

import com.next.step.step3.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int NOT_FOUND_MAX_POSITION = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNum = RandomNumberGenerator.generateRandomNum();
            car.moveCar(randomNum);
        }
    }

    public List<Car> carElements() {
        return this.cars;
    }

    public int findMaxPosition() {
        List<Car> cars = new ArrayList<>(this.cars);
        cars.sort(Comparator.comparingInt(Car::position).reversed());

        return cars.stream()
                .findFirst()
                .map(Car::position)
                .orElse(NOT_FOUND_MAX_POSITION);
    }

    public List<String> getWinnerNames(int maxPosition) {
        return cars.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
