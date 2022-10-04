package com.game.racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  ", "    ", "over5length"})
    @DisplayName("입력 값이 null이거나 빈 공백, 5자를 초과하는 문자일 경우 IllegalArgumentException throw 테스트")
    void car_move(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName(inputString);
        });
    }

}