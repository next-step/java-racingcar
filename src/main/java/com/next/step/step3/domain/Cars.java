package com.next.step.step3.domain;

import com.next.step.step3.util.RandomNumberGenerator;

import java.util.List;

public class Cars {

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
}
