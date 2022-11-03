package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racing.UserInputException.isValidForNumber;

public class InputTest {
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("입력된 이름에 공백이 있을 경우 제거한다")
    void removeWhiteSpace() {
        String[] input = {"pob i"};

        assertThat(inputView.removeWhiteSpace(input)).contains("pobi");
    }

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