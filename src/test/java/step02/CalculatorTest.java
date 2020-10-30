package step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @ParameterizedTest
    @CsvSource(value = {
            "3 + 5 / 2 * 5 + 10 - 5 = 25"
    }, delimiter = '=')
    public void 문자열계산기_테스트(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("단일 계산 사칙연산 테스트")
    @ParameterizedTest
    @MethodSource("provideOperatorAndOperandsAndResult")
    public void 단항연산자_테스트(Operator operator, int first, int second, int expected) {
        assertThat(operator.calculate(first, second)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOperatorAndOperandsAndResult () {
        return Stream.of(
            Arguments.of(Operator.PLUS, 1, 2, 3),
            Arguments.of(Operator.MINUS, 1, 2, -1),
            Arguments.of(Operator.MULTIPLE, 1, 2, 2),
            Arguments.of(Operator.DIVIDE, 4, 2, 2)
        );
    }

}
