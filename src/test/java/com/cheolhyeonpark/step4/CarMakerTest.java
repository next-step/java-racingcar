package com.cheolhyeonpark.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarMakerTest {

    @Test
    @DisplayName("자동차 이름에 값이 없으면 예외발생")
    public void throwExceptionWhenInputNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarMaker().getCars(""));
    }
}