package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@SuppressWarnings("NonAsciiCharacters")
class CalculatorTest {
    private Calculator<Integer> calculator;

    @BeforeEach
    void setup() {
        final Validator<String> validator = new MockExpressionValidator();
        calculator = new StringCalculator(validator);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "1 + 2,3",
            "1 + 2 + 3,6",
            "2 + 3 * 4 / 2,10",
            "1 + 2 + 3 + 4,10",
            "0 + 0 - 0 * 0,0",
            "1 - 2 - 3 - 4,-8",
            "1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 0,0"
    })
    void 계산이_잘_되는지(String validExpression, Integer expected) {
        final Integer actual = calculator.calculate(validExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 나눗셈_연산자_뒤에_0이_나오면_예외_발생() {
        final String dividedByZero = "1 + 2 - 3 * 4 / 0";
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.calculate(dividedByZero))
                .withMessageContaining("0");
    }
}
