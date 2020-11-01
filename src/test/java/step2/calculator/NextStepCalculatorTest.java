package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.calculator.domain.Expression;
import step2.calculator.domain.SymbolStack;

import static org.assertj.core.api.Assertions.assertThat;

class NextStepCalculatorTest {

    @DisplayName("사칙연산 수식을 문자열로 입력한 경우 정수를 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "1 + 1:2",
            "2 - 2:0",
            "3 * 3:9",
            "4 / 3:1",
            "4 / 5:0",
    }, delimiter = ':')
    void calculate_return_integer(final String input, final Integer expected) {
        // given
        final NextStepCalculator calculator = new NextStepCalculator();
        final SymbolStack symbolStack = new SymbolStack(new Expression(input));

        // when
        int result = calculator.calculate(symbolStack);

        // then
        assertThat(result).isEqualTo(expected);
    }
}