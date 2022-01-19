package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ValueSource(strings = {"", "  "})
    @ParameterizedTest
    void 입력값_null_or_빈칸(String input) {
        assertThat(Validator.checkValidate(input)).isFalse();
    }
}