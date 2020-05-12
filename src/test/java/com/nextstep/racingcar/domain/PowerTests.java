package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PowerTests {
    @DisplayName("Power는 생성되면 0 ~ 9 사이의 값을 랜덤으로 갖게 됨")
    @Test
    void powerGenerateTest() {
        Power power = Power.generate();
        assertThat(power.toInt() >= 0).isTrue();
        assertThat(power.toInt() <= 9).isTrue();
    }
}
