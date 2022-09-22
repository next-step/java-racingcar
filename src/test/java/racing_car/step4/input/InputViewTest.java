package racing_car.step4.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("범위를 벗어난 숫자 입력 시, 예외 던지기")
    void negativeCheck() {
        assertThatThrownBy(() -> InputView.checkNegative(-1))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("음수는 입력할 수 없습니다. 다시 입력해주세요.");
    }
    
}