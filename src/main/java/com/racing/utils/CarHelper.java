package com.racing.utils;

import java.util.Arrays;
import java.util.List;

public class CarHelper {
    private static final int VALID_CAR_NAME = 6;

    public static List<String> splitCarName(String carNames) {
        String[] names = carNames.split(",");

        return Arrays.asList(names);
    }

    public static boolean isValidCarName(String carName) {
        if (carName.isEmpty()) {
            return false;
        }
        
        return carName.length() < VALID_CAR_NAME;
    }
}
