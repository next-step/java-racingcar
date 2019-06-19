package com.iksoo.step3;

import java.util.ArrayList;
import java.util.List;

public class CheckRacingWinner {

    public List<Object> checkResult(Car[] cars) {
        List<Object> winner = new ArrayList<Object>();

        int maxDistance = checkWinnerDistance(cars);
        addWinnerList(cars, winner, maxDistance);

        return winner;
    }


    public int checkWinnerDistance(Car[] cars) {
        int maxDistance = 0;
        for (int i = 0; i < cars.length; i++) {
            int carDistance = cars[i].getFinalPosition();
            maxDistance = carDistance > maxDistance ? carDistance : maxDistance;
        }

        return maxDistance;
    }

    public void addWinnerList(Car[] cars, List<Object> winner, int maxDistance) {
        for (int i = 0; i < cars.length; i++) {
            isWinnerThenAdd(cars[i], winner, maxDistance);
        }
    }

    public void isWinnerThenAdd(Car car, List<Object> winner, int maxDistance) {
        if (maxDistance == car.getFinalPosition()) {
            winner.add(car.getCarName());
        }
    }
}
