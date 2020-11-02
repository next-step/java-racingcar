package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.calculator.domain.Expression;
import step2.calculator.domain.SymbolStack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step2.calculator.domain.Operation.ErrorMessage.CAN_NOT_DIVIDE_BY_ZERO;

class NextStepCalculatorTest {
    @DisplayName("calculate")
    @Nested
    class Calculate {
        @DisplayName("사칙연산 수식을 전달 받은 경우 계산 후 결과를 반환")
        @ParameterizedTest
        @CsvSource(value = {
                "2 + 3 * 4 / 2:10",
                "1 + 1:2",
                "2 - 2:0",
                "3 * 3:9",
                "4 / 3:1",
                "4 / 5:0",
        }, delimiter = ':')
        void return_result(final String input, final Integer expected) {
            // given
            final NextStepCalculator calculator = new NextStepCalculator();
            final SymbolStack symbolStack = new SymbolStack(new Expression(input));

            // when
            int result = calculator.calculate(symbolStack);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @DisplayName("0으로 나눈 경우 'IllegalArgumentException'을 throw")
        @Test
        void throw_IllegalArgumentException_when_divide_by_zero() {
            // given
            final String divideByZeroExpression = "1 / 0";
            final NextStepCalculator calculator = new NextStepCalculator();
            final SymbolStack symbolStack = new SymbolStack(new Expression(divideByZeroExpression));

            // when
            // when
            final Throwable thrown = catchThrowable(() -> {
                calculator.calculate(symbolStack);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAN_NOT_DIVIDE_BY_ZERO.getMessage());
        }
    }
}