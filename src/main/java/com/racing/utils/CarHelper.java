package com.racing.utils;

import java.util.Arrays;
import java.util.List;

public class CarHelper {
    public static List<String> splitCarName(String carNames) {
        String[] names = carNames.split(",");
        return Arrays.asList(names);
    }
}
