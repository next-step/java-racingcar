package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("자동차 경주의 우승자를 결정한다")
    @MethodSource("getCars")
    @ParameterizedTest
    void chooseWinners(List<Car> cars, List<Car> winningCars) {
        // given
        Winners winners = new Winners();

        // when
        winners.chooseWinners(cars);

        // then
        assertThat(winners.getWinners()).containsExactlyElementsOf(winningCars);
    }

    static Stream<Arguments> getCars() {
        Car car1 = new Car(0, "a");
        Car car2 = new Car(1, "b");
        Car car3 = new Car(2, "c");
        Car car4 = new Car(2, "d");

        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), Collections.singletonList(car3)),
                Arguments.of(Arrays.asList(car1, car2, car3, car4), Arrays.asList(car3, car4)),
                Arguments.of(Arrays.asList(car1, car2), Collections.singletonList(car2))
        );
    }
}