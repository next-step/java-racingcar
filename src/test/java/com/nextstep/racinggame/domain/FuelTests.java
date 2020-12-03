package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FuelTests {
    @DisplayName("숫자를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int value = 3;

        assertThat(new Fuel(value)).isEqualTo(new Fuel(value));
    }
}