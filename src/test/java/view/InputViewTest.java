package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp () {
        inputView = new InputView();
    }

    @ParameterizedTest
    @DisplayName("숫자 체크 throw IllegalArgumentException")
    @ValueSource(strings = {"a"})
    void isDigit (String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.isDigit(number))
                .withMessage("숫자가 아닙니다.");
    }
}