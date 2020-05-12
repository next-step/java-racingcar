package com.nextstep.racingcar.domain;

import com.nextstep.racingcar.domain.car.MoveStrategy;
import com.nextstep.racingcar.domain.car.Power;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTests {
    @DisplayName("전달된 값이 4이상일 때만 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void canMoveWhenExceedPowerFour(int value) {
        assertThat(MoveStrategy.isMoveable(Power.generateByInt(value))).isTrue();
    }

    @DisplayName("전달된 값이 4이하일 때는 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void cantMoveWhenBeneathPowerFour(int value) {
        assertThat(MoveStrategy.isMoveable(Power.generateByInt(value))).isFalse();
    }
}
