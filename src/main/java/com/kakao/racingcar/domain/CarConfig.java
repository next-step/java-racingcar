package com.kakao.racingcar.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarConfig {
    private CarConfig() {
    }

    private static final Random random = new Random();

    public static final int MOVE_PERCENTAGE = 4;
    public static final int BASE_PERCENTAGE = 10;
    public static final int BEGIN_INDEX = 0;

    public static List<Integer> randomNumberGenerator(int number) {
        return IntStream.range(BEGIN_INDEX, number).boxed()
                .map(x -> random.nextInt(BASE_PERCENTAGE))
                .collect(Collectors.toList());
    }
}
