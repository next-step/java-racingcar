package com.kkambi.racing.util;

import com.kkambi.racing.domain.Bound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    @DisplayName("주사위의 값이 Bound 내에 있는지?")
    @EnumSource(value = Bound.class)
    @ParameterizedTest
    void withinBound(Bound bound) {
        // when, then
        assertThat(Dice.roll(bound)).isLessThan(bound.getValue());
    }
}