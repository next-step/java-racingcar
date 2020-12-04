package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.nextstep.racinggame.domain.CarFixtures.*;
import static com.nextstep.racinggame.domain.CarsFixtures.ALL_NOT_MOVED_TEST123_CARS;
import static com.nextstep.racinggame.domain.CarsFixtures.ALL_ONE_MOVED_TEST123_CARS;
import static com.nextstep.racinggame.domain.GasStationFixtures.FOUR_FUEL_GAS_STATION;
import static com.nextstep.racinggame.domain.GasStationFixtures.THREE_FUEL_GAS_STATION;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
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
                Arguments.of(FOUR_FUEL_GAS_STATION, ALL_ONE_MOVED_TEST123_CARS),
                Arguments.of(THREE_FUEL_GAS_STATION, ALL_NOT_MOVED_TEST123_CARS)
        );
    }

    @DisplayName("현재 속한 차량들 중 가장 많이 움직인 차량을 구할 수 있다.")
    @Test
    void calculateMostMovedCarsTest() {
        Cars cars = new Cars(Arrays.asList(ONE_TEST1_CAR, ONE_TEST2_CAR, ZERO_TEST3_CAR));

        assertThat(cars.calculateMostMovedCars()).contains(ONE_TEST1_CAR);
        assertThat(cars.calculateMostMovedCars()).contains(ONE_TEST2_CAR);
    }
}
