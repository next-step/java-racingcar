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

    @DisplayName("현재 상태를 형식에 맞춰서 String으로 바꿀 수 있어야 한다.")
    @Test
    void toStringStatusTest() {
        CarRoundResult roundResult = CarRoundResult.create("poppo", MoveLength.createByValue(1));
        assertThat(roundResult.toStringStatus()).isEqualTo("poppo : -");
    }
}
