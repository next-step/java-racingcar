package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력이 숫자가 아니면 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","한"})
    void validInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           inputView.isValid(input);
        });
    }

    @DisplayName("입력이 널값이면 익셉션이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validNullInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.isValid(input);
        });
    }
}