package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.calculator.Expression;
import step2.calculator.NextStepCalculator;
import step2.calculator.Operation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

        // when
        int result = calculator.calculate(new Expression(input));

        // then
        assertThat(result).isEqualTo(expected);
    }
}