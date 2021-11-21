package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LocationTest {

    @DisplayName("위치는 음수일수 없다")
    @ValueSource(ints = {-5, -3, -1})
    @ParameterizedTest
    void locationMustNotBeMinus(int locationValue) {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Location(locationValue));
    }

    @DisplayName("위치 증가")
    @Test
    void locationMove() {
        // given
        Location location = new Location(0);

        // when
        Location locationAfterMove = location.move();

        // then
        assertThat(locationAfterMove.getValue()).isEqualTo(location.getValue() + 1);
    }

    @DisplayName("위치끼리 대소 비교할 수 있다")
    @Test
    void compareByValue() {
        // given
        Location location1 = new Location(0);
        Location location2 = new Location(1);

        // when
        // then
        assertThat(location1).isLessThan(location2);
        assertThat(location2).isGreaterThan(location1);
    }

    @DisplayName("위치끼리 동등 비교할 수 있다")
    @Test
    void equalsByValue() {
        // given
        Location location1 = new Location(1);
        Location location2 = new Location(1);

        // when
        // then
        assertThat(location1).isEqualTo(location2);
    }
}