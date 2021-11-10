package com.kakao.racingcar.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.kakao.racingcar.config.CarConstant.BASE_PERCENTAGE;
import static com.kakao.racingcar.config.CarConstant.BEGIN_INDEX;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    private static final Random random = new Random();

    public static List<Integer> generate(int number) {
        return IntStream.range(BEGIN_INDEX, number).boxed()
                .map(x -> random.nextInt(BASE_PERCENTAGE))
                .collect(Collectors.toList());
    }
}
