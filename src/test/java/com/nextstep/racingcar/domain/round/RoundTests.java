package com.nextstep.racingcar.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTests {
    @DisplayName("차량의 대수를 입력받아 Round에서 진행할 차량들을 등록한다.")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void createRoundTest(int carNumber) {
        Round round = Round.newRound(carNumber);
        assertThat(round.getCarNumber()).isEqualTo(carNumber);
    }
}
