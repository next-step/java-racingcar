package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 전진 시도")
    @MethodSource("getRandomValueWhenTryToMove")
    @ParameterizedTest
    void tryToMove(int randomValue, int expectedLocation) {
        // given
        Car car = new Car();

        // when
        car.tryToMove(randomValue);

        // then
        assertThat(car.getLocation()).isEqualTo(expectedLocation);
    }

    static Stream<Arguments> getRandomValueWhenTryToMove() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(4, 1),
                Arguments.of(9, 1)
        );
    }
}