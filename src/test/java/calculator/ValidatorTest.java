package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("사칙연산 이외의 기호 입력")
    void validateSymbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateSymbol("!"));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateSymbol("@"));
    }

    @Test
    @DisplayName("String으로 숫자가 아닌 문자 입력")
    void validateNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateNumber("a"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("공백 입력")
    void validateInputWithWhiteSpaces(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validateIsNotEmpty(input))
                .withMessage("입력값을 제대로 입력해주세요.");
    }

    @Test
    @DisplayName("input이 null일 경우 IllegalArgumentException")
    void validateInputWithNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validateIsNotEmpty(null))
                .withMessage("입력값을 제대로 입력해주세요.");
    }

    @Test
    @DisplayName("Token (List<String>)의 size validation")
    void validateSizeOf() {

        // 3개 이하
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateSizeOf(Arrays.asList("1", "+")));

        // 짝수개
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateSizeOf(Arrays.asList("1", "+", "3", "*")));

    }

}
