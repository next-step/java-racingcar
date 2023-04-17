package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class SimpleRacingCarTest {

    @Test
    @DisplayName("사용자 입력값이 1이하인 경우 예외 발생")
    void numberInputCheck() {
        assertThatThrownBy(() -> InputView.inputCheck(-1))
                .isInstanceOf(RuntimeException.class);
    }
}