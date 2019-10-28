package com.seok.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    static Stream<Arguments> strategies() {
        Movable alwaysMovable = () -> true;
        Movable immovable = () -> false;

        return Stream.of(
            Arguments.of(alwaysMovable, 1),
            Arguments.of(immovable, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("strategies")
    void move(Movable movable, int expected) {
        Car car = new Car("tom");
        car.setMoveAble(movable);
        car.move();
        assertThat(car.getLocation()).isEqualTo(expected);
    }
}