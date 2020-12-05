package com.nextstep.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int CAR_COUNT = 5;

    private final CarName carName = new CarName("test");

    @DisplayName("자동차에 이름 부여")
    @Test
    public void name(){
        Car car = new Car(carName, () -> 1);
        assertThat(car.getName()).isEqualTo("test");
    }

    @DisplayName("move 호출 시 값에 따른 이동 여부 확인")
    @ParameterizedTest
    @MethodSource
    public void tryMove(Supplier<Integer> numberSupplier, int count) {
        Car car = new Car(carName, numberSupplier);
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            car.tryMove();
        }
        assertThat(car.getPosition()).isEqualTo(count);
    }

    private static Stream<Arguments> tryMove() {
        Supplier<Integer> supplier1 = () -> 1;
        Supplier<Integer> supplier3 = () -> 3;
        Supplier<Integer> supplier4 = () -> 4;
        Supplier<Integer> supplier9 = () -> 9;

        return Stream.of(
                Arguments.of(supplier1, 0),
                Arguments.of(supplier3, 0),
                Arguments.of(supplier4, 1),
                Arguments.of(supplier9, 1)
        );
    }

    @DisplayName("limit이 5일때 현재 position에 따른 finished 체크")
    @ParameterizedTest
    @MethodSource
    public void isNotFinished(Supplier<Integer> supplier, int count, boolean expected) {
        Car car = new Car(carName, supplier);
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            car.tryMove();
        }

        assertThat(car.isNotFinished(CAR_COUNT)).isEqualTo(expected);
        assertThat(car.isFinished(CAR_COUNT)).isEqualTo(!expected);
    }

    private static Stream<Arguments> isNotFinished() {
        Supplier<Integer> supplier = () -> 9;
        return Stream.of(
                Arguments.of(supplier, 1, true),
                Arguments.of(supplier, 4, true),
                Arguments.of(supplier, 5, false)
        );
    }
}
