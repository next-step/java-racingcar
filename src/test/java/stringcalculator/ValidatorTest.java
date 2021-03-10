package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ValidatorTest {

    @DisplayName("null 입력 시 확인")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Validator.validateInput(null);
        });
    }

    @DisplayName("공백 입력 시 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void inputBlankTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Validator.validateInput(input);
        });
    }
}
