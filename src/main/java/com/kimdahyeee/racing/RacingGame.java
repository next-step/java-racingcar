package com.kimdahyeee.racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> racingCars;

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public RacingGame(List<String> names) {
        racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new Car(name));
        }
    }

    public void move() {
        for (Car car : racingCars) {
            car.move();
        }
    }
}
