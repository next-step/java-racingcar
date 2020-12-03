package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidFuelValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FuelTest {
    @DisplayName("값을 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int value = 3;

        assertThat(new Fuel(value)).isEqualTo(new Fuel(value));
    }

    @DisplayName("범위(0 ~ 9)를 벗어난 값으로 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, 10 })
    void createFailTest(int invalidValue) {
        assertThatThrownBy(() -> new Fuel(invalidValue)).isInstanceOf(InvalidFuelValueException.class);
    }
}
