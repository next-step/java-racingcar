package com.iksoo.step3;

import java.util.ArrayList;
import java.util.List;

public class CheckRacingWinner {

    public static List<Object> checkResult(Car[] cars, int maxDistance) {
        List<Object> winner = new ArrayList<Object>();

        for (int i = 0; i < cars.length; i++) {
            checkWinner(cars[i], winner, maxDistance);
        }

        return winner;
    }


    public static boolean checkWinner(Car car, List<Object> winner, int maxDistance) {
        car.maxDistance = checkDistance(car);

        if(addWinnerList(car, winner, maxDistance)) {
            return true;
        }

        return false;
    }

    public static int checkDistance(Car car) {
        int sumDistance = 0;
        for (int i = 0; i < car.carPosition.length(); i++) {
            sumDistance += Character.getNumericValue(car.carPosition.charAt(i));
        }

        return sumDistance;
    }

    public static boolean addWinnerList(Car car, List<Object> winner, int maxDistance) {

        System.out.println("maxDistance:"+maxDistance + ", carDistance : " + car.maxDistance);
        if (maxDistance == car.maxDistance) {
            winner.add(car.getCarName());
            System.out.println(winner);
            return true;
        }

        return false;
    }
}
