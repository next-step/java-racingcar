package step4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @ParameterizedTest(name = "{0} causes IllegalArgumentException")
    @ValueSource(strings = {"adf, abcdef"})
    public void illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> InputView.splitInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
