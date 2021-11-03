package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class EmptyInputValidatorTest {

    EmptyInputValidator validator = new EmptyInputValidator();

    @Test
    @DisplayName("input이 null이면 예외발생")
    void nullInputTest() {
        exceptionThrow(null,"input is null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("input이 공백이면 예외발생")
    void emptyInputTest(String input) {
        exceptionThrow(input,"input is empty or blank");
    }

    private void exceptionThrow(String input, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.check(input))
                .withMessage(message);
    }
}