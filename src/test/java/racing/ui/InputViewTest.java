package racing.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName(value = "0회 이하로 입력 불가능")
    @Test
    void input() {
        // given
        int inputNumber = 0;

        // when
        Assertions.assertThatThrownBy(() -> {
//            InputView.inputNumberOfAttempt(number);
            InputView.validate(inputNumber);
            // then
        }).hasMessageContaining("0 이하는 입력할 수 없습니다.");
    }
}