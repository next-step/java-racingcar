package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingStrategyTest {

    private RacingStrategy racingStrategy;

    @BeforeEach
    void setUp() {
        racingStrategy = new RacingStrategy();
    }

    @DisplayName("조건에 맞을 때 이동 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 234, 34, 635 })
    void isMove(final int moreCondition) {
        assertThat(racingStrategy.isMove(RacingStrategy.MORE_THAN_MOVING_CONDITION + moreCondition)).isTrue();
    }

    @DisplayName("조건에 맞지 않을 때 이동 안하는 것 확인")
    @ParameterizedTest
    @ValueSource(ints = { 1, 234, 34, 635 })
    void isNotMove(final int lessCondition) {
        assertThat(racingStrategy.isMove(RacingStrategy.MORE_THAN_MOVING_CONDITION - lessCondition)).isFalse();
    }
}
