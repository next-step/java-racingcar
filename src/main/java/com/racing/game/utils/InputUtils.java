package com.racing.game.utils;

import com.racing.game.entity.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {

    private InputUtils() {
        throw new IllegalArgumentException("Utility Class");
    }

    public static List<Car> toCarList(String carNames){
        return Arrays.stream(toSplitList(carNames))
                .map(Car::from)
                .collect(Collectors.toList());
    }

    public static String[] toSplitList(String input) {
        return input.split(",");
    }
}
