package com.nextstep.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @DisplayName("자동차 이름 5자 초과 체크")
    @Test
    public void isInvalidName() {
        String name = "aaaaaa";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(name + " is over limit");
    }
}
