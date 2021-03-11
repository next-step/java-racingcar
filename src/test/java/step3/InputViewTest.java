package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @ParameterizedTest(name = "{0} causes IllegalArgumentException")
    @ValueSource(strings = {"나", "+", "sd", "$"})
    public void illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> InputView.getInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0} causes NoSuchElementException")
    @ValueSource(strings = {"   ", " "})
    public void noSuchElementExceptionTest(String input) {
        assertThatThrownBy(() -> InputView.getInput(input))
                .isInstanceOf(NoSuchElementException.class);
    }

}
