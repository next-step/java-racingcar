package com.seok.racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class PositionTest {


    static Stream<Arguments> increment() {
        return Stream.of(
                Arguments.of(new Position(1), "-"),
                Arguments.of(new Position(4), "----")
        );
    }

    static Stream<Arguments> fastThan() {
        return Stream.of(
                Arguments.of(new Position(1), Position.ZERO, true),
                Arguments.of(new Position(4), new Position(5), false),
                Arguments.of(new Position(3), new Position(3), true)
        );
    }

    @ParameterizedTest
    @MethodSource("increment")
    void increment(Position position, String expected) {
        assertThat(position.toString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("fastThan")
    void fastThan(Position position1, Position position2, boolean expected) {
        assertThat(position1.fastThan(position2)).isEqualTo(expected);
    }


}