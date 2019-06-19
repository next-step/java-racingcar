package stringcalculator.application;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.domain.Expression;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Expression expression;

    @BeforeEach
    void setUp() {
        this.expression = new Expression("2 + 3 * 4 / 2");
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 + 4 : 7", "1 + 2 + 3 : 6", "2 + 3 + 11 : 16"}, delimiter = ':')
    void additionTest(String source, Double expectedResult) {
        double result = new Expression(source).calculate();
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 - 4 : -1", "1 - 2 - 3 : -4", "11 - 3 - 2 : 6"}, delimiter = ':')
    void subtractionTest(String source, Double expectedResult) {
        double result = new Expression(source).calculate();
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 * 4 : 12", "1 * 2 * 3 : 6", "11 * 3 * 2 : 66"}, delimiter = ':')
    void multiplicationTest(String source, Double expectedResult) {
        double result = new Expression(source).calculate();
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 / 4 : 0.75", "1 / 2 / 3 : 0.17", "11 / 3 / 2 : 1.83"}, delimiter = ':')
    void divisionTest(String source, Double expectedResult) {
        double result = new Expression(source).calculate();
        assertThat(result).isCloseTo(expectedResult, Offset.offset(0.01));
    }

    @DisplayName("[2 + 3 * 4 / 2] 연산 테스트")
    @Test
    void calculateTest() {
        double result = expression.calculate();
        assertThat(result).isEqualTo(10);
    }

}
