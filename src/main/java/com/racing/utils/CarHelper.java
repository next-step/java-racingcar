package com.racing.utils;

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
}
