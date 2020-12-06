package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final Name HELLO_NAME = new Name("hello");

    @DisplayName("차량의 이름을 입력받아 객체 생성 가능")
    @Test
    void createTest() {
        assertThat(Car.of(HELLO_NAME)).isNotNull();
    }

    @DisplayName("이동 시 주입된 연료의 값에 따라 이동 가능")
    @ParameterizedTest
    @MethodSource("moveTestResource")
    void moveTest(MovePolicy movePolicy, Car expectedCar) {
        Car movedCar = Car.of(HELLO_NAME)
                .move(movePolicy);

        assertThat(movedCar).isEqualTo(expectedCar);
    }
    public static Stream<Arguments> moveTestResource() {
        return Stream.of(
                Arguments.of(new ForceMovePolicy(), new Car(1, HELLO_NAME)),
                Arguments.of(new ForceNotMovePolicy(), new Car(0, HELLO_NAME))
        );
    }
}
