package com.seok.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    static Stream<Arguments> getWinners() {
        Racer foo = new Racer("foo");
        Racer bar = new Racer("bar");
        Racer baz = new Racer("baz");

        Car carFoo = new Car(foo, new Position(1));
        Car carBar= new Car(bar, new Position(1));
        Car carBaz= new Car(baz, Position.ZERO);


        return Stream.of(
            Arguments.of(new Cars(Arrays.asList(carFoo, carBar, carBaz))
                    , new Winners(Arrays.asList(new Winner(foo), new Winner(bar)))),
            Arguments.of(new Cars(Arrays.asList(carFoo, carBaz)),
                    new Winners(Arrays.asList(new Winner(foo)))),
                Arguments.of(new Cars(Arrays.asList(carBaz)),
                    new Winners(Arrays.asList(new Winner(baz))))
        );
    }
    @ParameterizedTest
    @MethodSource("getWinners")
    void getWinners(Cars cars, Winners expected) {
        assertThat(cars.getWinners()).isEqualTo(expected);
    }


}