package com.kkambi.racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    @DisplayName("주사위의 값이 Bound 내에 있는지?")
    @ValueSource(ints = {1, 4, 10})
    @ParameterizedTest
    void withinBound(int bound) {
        // when, then
        assertThat(Dice.roll(bound)).isLessThan(bound);
    }
}