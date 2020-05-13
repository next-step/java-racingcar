package com.nextstep.racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("0 ~ 9를 벗어난 값으로 Power 생성 시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = { -4, -100, 10, 15 })
    void generateByIntFailTest(int invalidValue) {
        assertThatThrownBy(() -> Power.generateByInt(invalidValue)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동등성 비교")
    @Test
    public void equalTest() {
        Power power1 = Power.generateByInt(1);
        Power power2 = Power.generateByInt(1);
        assertThat(power1.equals(power2)).isTrue();
    }

    @DisplayName("대소 비교")
    @Test
    public void greaterSmallerTest() {
        Power powerOne = Power.generateByInt(1);
        Power powerTwo = Power.generateByInt(2);
        assertThat(powerOne.compareTo(powerTwo)).isEqualTo(-1);
        assertThat(powerOne.compareTo(powerOne)).isEqualTo(0);
        assertThat(powerTwo.compareTo(powerOne)).isEqualTo(1);
    }
}
