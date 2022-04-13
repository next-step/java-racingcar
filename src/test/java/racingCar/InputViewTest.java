package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @DisplayName("입력값을 integer로 변환")
    @Test
    void inputStringIsNumber() {
        assertThat(InputView.toInt("3")).isEqualTo(3);
    }

    @DisplayName("입력값이 숫자가 아닐 경우 throw RuntimeException")
    @Test
    void inputStringIsNotNumber() {
        assertThatThrownBy(() -> {
            InputView.toInt("a");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("입력값이 음수일 경우 throw RuntimeException")
    @Test
    void inputStringIsNegativeNumber() {
        assertThatThrownBy(() -> {
            InputView.toInt("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
