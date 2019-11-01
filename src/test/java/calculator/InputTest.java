package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("null 입력 시 확인")
    void nullTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.valueToCalulateValidate(inputStr));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("공백 문자 입력 시 확인")
    void emptyStringTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.valueToCalulateValidate(inputStr));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "$", "%"})
    @DisplayName("사칙연산 기호 정상여부 확인")
    void calcStringTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.operationSymbolValidate(inputStr));
    }
}
