package com.jaenyeong.mission2.racingcar.util;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {
    private static final int EMPTY = 0;

    public static boolean invalidNamesOfCars(final List<String> carNames) {
        if (carNames.size() <= EMPTY) {
            return true;
        }

        final List<String> collect = carNames.stream()
            .filter((name) -> name.trim().length() > EMPTY)
            .collect(Collectors.toList());

        return !(carNames.size() == collect.size());
    }
}
