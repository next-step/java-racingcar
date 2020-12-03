package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTests {
    @DisplayName("생성하고 싶은 Car의 수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int carDemand = 3;
        Cars cars = Cars.of(carDemand);

        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(carDemand);
    }

    @DisplayName("속한 차량들을 한번에 움직일 수 있다.")
    @ParameterizedTest
    @MethodSource("moveAllTestResource")
    void moveAllTest(GasStation gasStation, Cars expectedCars) {
        int carDemand = 3;
        Cars cars = Cars.of(carDemand);

        Cars movedCars = cars.move(gasStation);

        assertThat(movedCars)
                .isEqualTo(expectedCars);
    }
    public static Stream<Arguments> moveAllTestResource() {
        return Stream.of(
                Arguments.of(
                        new FourFuelGasStation(),
                        new Cars(Arrays.asList(new Car(1), new Car(1), new Car(1)))
                ),
                Arguments.of(
                        new ThreeFuelGasStation(),
                        new Cars(Arrays.asList(new Car(0), new Car(0), new Car(0)))
                )
        );
    }
}