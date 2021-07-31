package carracing.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    @ParameterizedTest(name = "유효하지 않은 입력값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "a"})
    public void validateMoveCountTest(String invalidInput) {
        InputView inputView = InputView.of(new ByteArrayInputStream(invalidInput.getBytes()));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.getMoveCount())
                .withMessageContaining(invalidInput);
    }

}