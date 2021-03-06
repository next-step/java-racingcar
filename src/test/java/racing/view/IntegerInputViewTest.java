package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegerInputViewTest {

    private final IntegerInputView inputView = new IntegerInputView("Test");

    @Test
    @DisplayName("사용자 입력을 정수로 반환한다.")
    void parseInteger() {
        assertThat(inputView.parse("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("정수로 변환할 수 없는 입력은 예외처리한다.")
    void parseIfStringIsNotInteger() {
        assertThatThrownBy(() -> inputView.parse("a")).isInstanceOf(RuntimeException.class);
    }
}
