package com.iksoo.step3;

import java.util.ArrayList;
import java.util.List;

public class CheckRacingWinner {

    public List<Object> checkWinner(List<Car> cars) {
        List<Object> winner = new ArrayList<>();

        checkEachCars(cars, winner, getMaxDistance(cars));

        return winner;
    }

    public int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;

        for (int i = 0; i < cars.size(); i++) {
            int carDistance = cars.get(i).getFinalPosition();
            maxDistance = carDistance > maxDistance ? carDistance : maxDistance;
        }

        return maxDistance;
    }

    public void checkEachCars(List<Car> cars, List<Object> winner, int maxDistance) {
        for (int i = 0; i < cars.size(); i++) {
            isWinnerThenAdd(cars.get(i), winner, maxDistance);
        }
    }

    public void isWinnerThenAdd(Car car, List<Object> winner, int maxDistance) {
        if (maxDistance == car.getFinalPosition()) {
            winner.add(car.getCarName());
        }
    }
}
