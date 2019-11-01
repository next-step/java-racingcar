package com.seok.racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    static Stream<Arguments> movable() {
        return Stream.of(
                Arguments.of(new Car(new Racer("foo"), new Position(0)), new Car(new Racer("foo"), new Position(1))),
                Arguments.of(new Car(new Racer("foo"), new Position(2)), new Car(new Racer("foo"), new Position(3)))
        );
    }

    static Stream<Arguments> immovable() {
        return Stream.of(
                Arguments.of(new Car(new Racer("foo"), new Position(0)), new Car(new Racer("foo"), new Position(0))),
                Arguments.of(new Car(new Racer("foo"), new Position(2)), new Car(new Racer("foo"), new Position(2)))
        );
    }

    static Stream<Arguments> isTie() {
        Car foo = new Car(new Racer("foo"), Position.ZERO);
        Car baz = new Car(new Racer("baz"), Position.ZERO);
        Car bar = new Car(new Racer("bar"), new Position(3));
        return Stream.of(
                Arguments.of(foo, bar, false),
                Arguments.of(bar, foo, false),
                Arguments.of(foo, baz, true)
        );
    }

    static Stream<Arguments> fastThan() {
        Car foo = new Car(new Racer("foo"), Position.ZERO);
        Car baz = new Car(new Racer("baz"), Position.ZERO);
        Car bar = new Car(new Racer("bar"), new Position(3));
        return Stream.of(
                Arguments.of(foo, bar, bar),
                Arguments.of(bar, foo, bar),
                Arguments.of(foo, baz, foo)
        );
    }

    @ParameterizedTest
    @MethodSource("movable")
    void movable(Car car, Car expected) {
        car.move(() -> true);
        assertThat(car).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("immovable")
    void immovable(Car car, Car expected) {
        car.move(() -> false);
        assertThat(car).isEqualTo(expected);
    }

    @Test
    void awarded() {
        Racer racer = new Racer("foo");
        Car car = new Car(racer, new Position(3));
        assertThat(car.awarded()).isEqualTo(new Winner(racer));
        assertThat(car.awarded().toString()).isEqualTo("foo");
    }

    @ParameterizedTest
    @MethodSource("isTie")
    void isTie(Car car1, Car car2, boolean expected) {
        assertThat(car1.isTie(car2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("fastThan")
    void fastThan(Car car1, Car car2, Car expected) {
        assertThat(car1.fastThan(car2)).isEqualTo(expected);
    }
}