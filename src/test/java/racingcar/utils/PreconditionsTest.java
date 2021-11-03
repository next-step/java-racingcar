package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class PreconditionsTest {

    @Test
    @DisplayName("값이 정상적인 경우")
    void checkNotNull() {
        String param1 = "test data";
        Preconditions.checkNotNull(param1, "param1은 필수값입니다.");
    }

    @Test
    @DisplayName("값이 null 인 경우 예외가 발생 검증")
    void checkNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> Preconditions.checkNotNull(null, "param1은 필수값입니다."));
    }
}
