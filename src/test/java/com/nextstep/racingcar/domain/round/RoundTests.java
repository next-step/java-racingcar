package com.nextstep.racingcar.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("모든 차량을 1회씩 출발시킨다.")
    @Test
    void moveAllCar() {
        // TODO: 테스트 용이성을 위해 강제로 움직일 수 있는 가짜 차량을 만들고 돌아오자
        Round round = Round.newRound(3);
        round.moveAll();
    }
}
