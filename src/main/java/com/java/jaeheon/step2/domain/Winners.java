package com.java.jaeheon.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    static List<Car> winners = new ArrayList<Car>();

    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        for (Car car : cars) {
            winnerAdd(car, maxPosition);
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private static void winnerAdd(Car car, int maxPosition) {
        if (car.matchPosition(maxPosition)) {
            winners.add(car);
        }
    }
}
