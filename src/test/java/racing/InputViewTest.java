package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("음수를 입력하면 예외를 던진다")
    void test2(){
        InputView inputView = InputView.getInstance();

        assertThatThrownBy(()-> inputView.inputTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수를 입력할 수 없다");
    }
}