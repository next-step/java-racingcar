package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTests {
    private static final GasStation MOVE_GAS_STATION = new FourFuelGasStation();
    private static final GasStation NOT_MOVE_GAS_STATION = new ThreeFuelGasStation();

    @DisplayName("주유할 주유소를 인자로 받아서 객체 생성 가능")
    @Test
    void createTest() {
        assertThat(new Car(MOVE_GAS_STATION)).isNotNull();
    }

    @DisplayName("이동 시 주입된 연료의 값에 따라 이동 가능")
    @ParameterizedTest
    @MethodSource("moveTestResource")
    void moveTest(Car car, int expectedDistance) {
        car.move();

        assertThat(car.getDistance()).isEqualTo(expectedDistance);
    }
    public static Stream<Arguments> moveTestResource() {
        return Stream.of(
                Arguments.of(new Car(MOVE_GAS_STATION), 1),
                Arguments.of(new Car(NOT_MOVE_GAS_STATION), 0)
        );
    }
}