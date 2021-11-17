package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차 전진 시도")
    @MethodSource("getRandomValueWhenTryToMove")
    @ParameterizedTest
    void tryToCarMove(int randomValue, Location expectedLocation) {
        // given
        Car car = new Car(0, "pobi");

        // when
        car.tryToMove(randomValue);

        // then
        assertThat(car.getLocation()).isEqualTo(expectedLocation);
    }

    static Stream<Arguments> getRandomValueWhenTryToMove() {
        return Stream.of(
                Arguments.of(1, new Location(0)),
                Arguments.of(4, new Location(1)),
                Arguments.of(9, new Location(1))
        );
    }

    @DisplayName("자동차 위치는 음수일수 없다")
    @ValueSource(ints = {-5, -3, -1})
    @ParameterizedTest
    void locationMustNotBeMinus(int locationValue) {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Location(locationValue));
    }

    @DisplayName("자동차 위치 증가")
    @Test
    void locationMove() {
        // given
        Location location = new Location(0);

        // when
        Location locationAfterMove = location.move();

        // then
        assertThat(locationAfterMove.getValue()).isEqualTo(location.getValue() + 1);
    }

    @DisplayName("자동차 이름은 5글자를 초과할 수 없다")
    @ValueSource(strings = {"123456", "coding"})
    @ParameterizedTest
    void nameMustNotOver5(String name) {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }
}