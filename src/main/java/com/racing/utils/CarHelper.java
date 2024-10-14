package com.racing.utils;

import com.racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarHelper {
    private static final int VALID_CAR_NAME = 6;

    public static List<String> splitCarName(String carNames) {
        String[] namesArray = carNames.split(",");
        List<String> validNames = new ArrayList<>();
        addValidNames(namesArray, validNames);
        return validNames;
    }

    private static void addValidNames(String[] namesArray, List<String> validNames) {
        for (String name : namesArray) {
            addIfValid(name, validNames);
        }
    }

    private static void addIfValid(String carName, List<String> validNames) {
        if (isValidCarName(carName)) {
            validNames.add(carName);
        }
    }

    public static boolean isValidCarName(String carName) {
        if (carName.isEmpty()) {
            return false;
        }

        return carName.length() < VALID_CAR_NAME;
    }

    public static List<Car> determineWinners(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int maxState = findMaxState(carList);

        for (Car car : carList) {
            addWinners(car, maxState, winners);
        }

        return winners;
    }

    private static void addWinners(Car car, int maxState, List<Car> winners) {
        if (car.getState() == maxState) {
            winners.add(car);
        }
    }

    private static int findMaxState(List<Car> carList) {
        int maxState = 0;
        for (Car car : carList) {
            maxState = car.isDefeated(maxState) ? maxState : car.getState();

        }

        return maxState;
    }

}
