package com.seok.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    static Stream<Arguments> cars() {
        Movable alwaysMovable = () -> true;

        Car tom = new Car("tom", alwaysMovable);
        Car leo = new Car("leo", alwaysMovable);
        tom.move();
        leo.move();
        Car jay = new Car("jay");

        return Stream.of(
            Arguments.of(new Cars(Arrays.asList(tom, jay)), new String[]{"tom"}),
            Arguments.of(new Cars(Arrays.asList(tom, leo, jay)), new String[]{"tom", "leo"})
        );
    }

    @ParameterizedTest
    @MethodSource("cars")
    void getWinner(Cars cars, String[] expected) {
        assertThat(cars.getWinners()).containsOnly(expected);
    }
}