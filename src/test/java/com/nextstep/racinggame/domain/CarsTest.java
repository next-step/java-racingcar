package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.nextstep.racinggame.domain.CarsFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private static final Car ZERO_TEST1_CAR = new Car(0, new Name("test1"));
    private static final Car ZERO_TEST2_CAR = new Car(0, new Name("test2"));
    private static final Car ZERO_TEST3_CAR = new Car(0, new Name("test3"));
    private static final Car ONE_TEST1_CAR = new Car(1, new Name("test1"));
    private static final Car ONE_TEST2_CAR = new Car(1, new Name("test2"));

    @DisplayName("Cars 컬렉션을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Cars cars = new Cars(Arrays.asList(ZERO_TEST1_CAR, ZERO_TEST2_CAR, ZERO_TEST3_CAR));

        assertThat(cars).isNotNull();
    }

    @DisplayName("속한 차량들을 한번에 움직일 수 있다.")
    @ParameterizedTest
    @MethodSource("moveAllTestResource")
    void moveAllTest(MovePolicy movePolicy, Cars expectedCars) {
        Cars cars = new Cars(Arrays.asList(ZERO_TEST1_CAR, ZERO_TEST2_CAR, ZERO_TEST3_CAR));

        Cars movedCars = cars.move(movePolicy);

        assertThat(movedCars)
                .isEqualTo(expectedCars);
    }
    public static Stream<Arguments> moveAllTestResource() {
        return Stream.of(
                Arguments.of(new ForceMovePolicy(), ALL_ONE_MOVED_TEST123_CARS),
                Arguments.of(new ForceNotMovePolicy(), ALL_NOT_MOVED_TEST123_CARS)
        );
    }

    @DisplayName("현재 속한 차량들 중 가장 많이 움직인 차량을 구할 수 있다.")
    @Test
    void calculateMostMovedCarsTest() {
        Cars cars = new Cars(Arrays.asList(ONE_TEST1_CAR, ONE_TEST2_CAR, ZERO_TEST3_CAR));

        assertThat(cars.calculateMostMovedCars()).isEqualTo(TEST1_TEST2_WINNING_CARS);
    }
}
