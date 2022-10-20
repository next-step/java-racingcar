package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.UserInputException.isValidForNumber;

public class InputTest {

    @Test
    @DisplayName("[예외] 숫자 이외의 값을 전달하는 경우")
    void isNumber() {
        assertThatThrownBy(() -> isValidForNumber("#"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("[예외] 음수를 전달하는 경우")
    void negative() {
        assertThatThrownBy(() -> isValidForNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}