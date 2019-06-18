package com.iksoo.step3;

import java.util.ArrayList;
import java.util.List;

public class CheckRacingWinner {

    public static List<Object> checkResult(Car[] cars) {
        List<Object> winner = new ArrayList<Object>();

        int maxDistance = checkDistance(cars, winner);
        checkWinner(cars, winner, maxDistance);

        return winner;
    }


    public static int checkDistance(Car[] cars, List<Object> winner) {
        int maxDistance = 0;
        for (int i = 0; i < cars.length; i++) {
            cars[i].currentDistance = checkCurrentPosition(cars[i]);
            maxDistance = cars[i].currentDistance > maxDistance ? cars[i].currentDistance : maxDistance;
        }

        return maxDistance;
    }

    public static int checkCurrentPosition(Car car) {
        int sumDistance = 0;
        for (int i = 0; i < car.carPosition.length(); i++) {
            sumDistance += Character.getNumericValue(car.carPosition.charAt(i));
        }

        return sumDistance;
    }

    public static void checkWinner(Car[] cars, List<Object> winner, int maxDistance) {
        for (int i = 0; i < cars.length; i++) {
            addWinnerList(cars[i], winner, maxDistance);
        }
    }

    public static boolean addWinnerList(Car car, List<Object> winner, int maxDistance) {
        if (maxDistance == car.currentDistance) {
            winner.add(car.getCarName());
            return true;
        }

        return false;
    }
}
