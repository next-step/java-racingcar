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
        String trimmedName = carName.trim();
        if (isValidCarName(trimmedName)) {
            validNames.add(trimmedName);
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
        int maxPosition = findMaxPosition(carList);

        for (Car car : carList) {
            addWinners(car, maxPosition, winners);
        }

        return winners;
    }

    private static void addWinners(Car car, int maxPosition, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private static int findMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = car.isDefeated(maxPosition) ? maxPosition : car.getPosition();
        }

        return maxPosition;
    }

}
