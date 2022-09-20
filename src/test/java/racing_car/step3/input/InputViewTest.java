package racing_car.step3.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("범위를 벗어난 숫자 입력 시, 예외 던지기")
    void isNegative() {
        assertThatThrownBy(() -> InputView.isNegative(-1))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage(InputView.NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
    }
    
}