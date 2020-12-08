package com.jaenyeong.mission2.racingcar.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@DisplayName("테스트시 자주 쓰이는 기능 추출")
public class BaseTest {

    protected static Stream<Arguments> randomIntValues() {
        return Stream.of(
            Arguments.of(getRandomValue()),
            Arguments.of(getRandomValue()),
            Arguments.of(getRandomValue()),
            Arguments.of(getRandomValue())
        );
    }

    protected static int getRandomValue() {
        return ThreadLocalRandom.current()
            .nextInt(1, 20);
    }

    protected static Stream<Arguments> countAndValidName() {
        return Stream.of(
            Arguments.of(getRandomValue(), Arrays.asList("재녕", "King", "Apple")),
            Arguments.of(getRandomValue(), Arrays.asList("12345", "1234", "123", "12", "1"))
        );
    }
}
