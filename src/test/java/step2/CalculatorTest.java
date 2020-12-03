package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 5 - 2 * 10 / 2:9",
            "10 * 5 + 3 - 4:7",
            "8 - 3:3",
            "9 / 3 + 10 - 2 * 1:9"}, delimiter = ':')
    @DisplayName("사칙연산 문자열 분해 테스트")
    void splitStringTest(String input, int expected) {
        String[] result = calculator.splitStringByBlankValue(input);

        assertThat(result.length).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "9", "10", "55", "100"})
    @DisplayName("숫자 검증 통과 테스트")
    void numberPassTest(String input) {
        assertThat(calculator.isNumber(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "오", "*", "십7", "-", "/"})
    @DisplayName("숫자 검증 실패 테스트")
    void numberFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.isNumber(input))
                .withMessageMatching("숫자가 아닙니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "*", "-", "/"})
    @DisplayName("사칙연산 기호 검증 통과 테스트")
    void operationPassTest(String input) {
        assertThat(calculator.isOperation(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "$", "101", "%"})
    @DisplayName("사칙연산 기호 검증 실패 테스트")
    void operationFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.isOperation(input))
                .withMessageMatching("사칙연산 기호가 아닙니다");
    }
}
