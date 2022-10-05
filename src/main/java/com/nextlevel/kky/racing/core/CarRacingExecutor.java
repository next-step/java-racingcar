package com.nextlevel.kky.racing.core;

import java.util.ArrayList;
import java.util.List;

public class CarRacingExecutor {

    public List<Car> carList;

    public CarRacingExecutor(int carCount) {
        carList = new ArrayList();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public CarRacingExecutor(int carCount, String names[]) {
        carList = new ArrayList();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(names[i]));
        }
    }

    public void proceedNextRound() {
        carList.forEach(Car::move);
    }
}
