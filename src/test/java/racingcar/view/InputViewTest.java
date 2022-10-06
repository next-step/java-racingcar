package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("round 입력 시 음수일 경우 에러 발생")
    void round_음수() {
        assertThatThrownBy(() -> InputView.roundValidCheck(-1))
                .isInstanceOf(RuntimeException.class);
    }
}
