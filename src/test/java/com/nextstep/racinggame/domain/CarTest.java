package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.nextstep.racinggame.domain.GasStationFixtures.FOUR_FUEL_GAS_STATION;
import static com.nextstep.racinggame.domain.GasStationFixtures.THREE_FUEL_GAS_STATION;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("주유할 주유소를 인자로 받아서 객체 생성 가능")
    @Test
    void createTest() {
        assertThat(Car.of()).isNotNull();
    }

    @DisplayName("이동 시 주입된 연료의 값에 따라 이동 가능")
    @ParameterizedTest
    @MethodSource("moveTestResource")
    void moveTest(GasStation gasStation, Car expectedCar) {
        Car movedCar = Car.of()
                .move(gasStation);

        assertThat(movedCar).isEqualTo(expectedCar);
    }
    public static Stream<Arguments> moveTestResource() {
        return Stream.of(
                Arguments.of(FOUR_FUEL_GAS_STATION, new Car(1)),
                Arguments.of(THREE_FUEL_GAS_STATION, new Car(0))
        );
    }
}
