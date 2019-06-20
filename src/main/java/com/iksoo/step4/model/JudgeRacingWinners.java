package com.iksoo.step4.model;

import java.util.ArrayList;
import java.util.List;

public class JudgeRacingWinners {

    public static List<String> judgeRacingWinners(List<Car> cars) {
        List<String> winnersName = arrangeWinners(cars, getWinnersDistance(cars));

        return winnersName;
    }

    public static int getWinnersDistance(List<Car> cars) {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            int carDistance = cars.get(i).getFinalPosition();
            maxDistance = carDistance > maxDistance ? carDistance : maxDistance;
        }
        return maxDistance;
    }

    public static List<String> arrangeWinners(List<Car> cars, int maxDistance) {
        List<String> winnersName = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            winnersName = addWinnerName(cars.get(i), winnersName, maxDistance);
        }

        return winnersName;
    }

    public static List<String> addWinnerName(Car car, List<String> winnersName, int maxDistance) {
        if (car.isVictory(maxDistance)) {
            winnersName.add(car.getCarName());
        }

        return winnersName;
    }
}
