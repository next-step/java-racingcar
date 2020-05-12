package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PowerTests {
    @DisplayName("Power는 생성되면 0 ~ 9 사이의 값을 랜덤으로 갖게 됨")
    @Test
    void powerGenerateTest() {
        Power power = Power.generate();
        assertThat(power.toInt() >= 0).isTrue();
        assertThat(power.toInt() <= 9).isTrue();
    }

    @DisplayName("int 값을 입력받아 Power를 생성할 수 있다.(패키지 내부용)")
    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 5, 9 })
    void generatePowerByInt(int value) {
        Power power = Power.generateByInt(value);
        assertThat(power.toInt()).isEqualTo(value);
    }
}
