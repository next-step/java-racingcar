package com.iksoo.step3;

import java.util.ArrayList;
import java.util.List;

public class CheckRacingWinner {

    public List<Object> checkResult(Car[] cars) {
        List<Object> winner = new ArrayList<Object>();

        int maxDistance = checkDistance(cars);
        checkWinner(cars, winner, maxDistance);

        return winner;
    }


    public int checkDistance(Car[] cars) {
        int maxDistance = 0;
        for (int i = 0; i < cars.length; i++) {
            int carDistance = cars[i].getCurrentDistance();
            maxDistance = carDistance > maxDistance ? carDistance : maxDistance;
        }

        return maxDistance;
    }

    public void checkWinner(Car[] cars, List<Object> winner, int maxDistance) {
        for (int i = 0; i < cars.length; i++) {
            addWinnerList(cars[i], winner, maxDistance);
        }
    }

    public boolean addWinnerList(Car car, List<Object> winner, int maxDistance) {
        if (maxDistance == car.getCurrentDistance()) {
            winner.add(car.getCarName());
            return true;
        }

        return false;
    }
}
