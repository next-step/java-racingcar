package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputTest {

    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @NullSource
    void nullTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.valueToCalulateValidate(inputStr);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void emptyStringTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           inputValidator.valueToCalulateValidate(inputStr);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "$", "%"})
    void calcStringTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           inputValidator.operationSymbolValidate(inputStr);
        });
    }
}
