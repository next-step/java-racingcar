package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.MoveLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRoundResultTests {
    @DisplayName("운전자명, 현재 거리를 입력받아서 RoundResult 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(CarRoundResult.create("poppo", MoveLength.createZero())).isNotNull();
    }
}
