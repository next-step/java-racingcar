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

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("사칙연산 이외의 기호 입력")
    void validateSymbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateSymbol("!"));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateSymbol("@"));
    }

    @Test
    @DisplayName("String으로 숫자가 아닌 문자 입력")
    void validateNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateNumber("a"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("공백 입력")
    void validateInputWithWhiteSpaces(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.validateIsNotEmpty(input))
                .withMessage("입력값을 제대로 입력해주세요.");
    }

    @Test
    @DisplayName("input이 null일 경우 IllegalArgumentException")
    void validateInputWithNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.validateIsNotEmpty(null))
                .withMessage("입력값을 제대로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 - 3", "11 * 2 / 3"})
    @DisplayName("Tokenize")
    void tokenize(String input) {
        List<String> result = calculator.tokenize(input);

        assertThat(result.size()).isNotZero();
    }

    @Test
    @DisplayName("Token (List<String>)의 size validation")
    void validateSizeOf() {

        // 3개 이하
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateSizeOf(Arrays.asList("1", "+")));

        // 짝수개
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateSizeOf(Arrays.asList("1", "+", "3", "*")));

    }

    @Test
    @DisplayName("client에게 제공되는 public method calculate")
    void calculate() {

        assertThat(calculator.calculate("1 + 2 * 3")).isEqualTo(9);
        assertThat(calculator.calculate("1 + 1 * 0")).isEqualTo(0);
        assertThat(calculator.calculate("1 + 4 * 3")).isEqualTo(15);
        assertThat(calculator.calculate("2 * 3")).isEqualTo(6);

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("2 *"));

    }

}